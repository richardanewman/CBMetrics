
import { Component, OnInit } from '@angular/core';
import { UserAccount } from 'src/app/models/user-account';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { UserAccountService } from 'src/app/services/user-account.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
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

  logout() {
    if (this.auth.checkLogin()) {
      this.auth.logout();
      this.route.navigateByUrl('logout');
    } else {
      this.route.navigateByUrl('login');
    }
  }

  checkIfLoggedIn() {
    return this.auth.checkLogin();
  }


}
