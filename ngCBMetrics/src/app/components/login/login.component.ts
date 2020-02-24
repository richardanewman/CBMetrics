import { UserAccountService } from './../../services/user-account.service';
import { UserAccount } from './../../models/user-account';
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  currentUser = new UserAccount();
  constructor(
    private auth: AuthService,
    private route: Router,
    private uSvc: UserAccountService
  ) {}

  ngOnInit() {}

  login(loginForm: NgForm) {
    this.auth.login(loginForm.value.username, loginForm.value.password).subscribe(
      dat => {
        this.uSvc.getUserInSession().subscribe(
          user => {
            this.currentUser = user;
            if (this.currentUser.role === 'ADMIN') {
              this.route.navigateByUrl('admin');
            } else {
              this.route.navigateByUrl('profile');
            }
          },
          err => {
            console.log('in login, get user session');
            console.log(err);
            this.route.navigateByUrl('login');
          }
          );
        },
        err => {
          console.log('in login');
          console.log(err);
          this.route.navigateByUrl('login');
      }
    );
  }
}
