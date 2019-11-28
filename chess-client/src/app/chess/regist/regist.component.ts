import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-regist',
  templateUrl: './regist.component.html',
  styleUrls: ['./regist.component.css']
})
export class RegistComponent implements OnInit {

  public constructor(
    private readonly authService: AuthService,
    private readonly router: Router
  ) { }

  public ngOnInit(): void {
  }

  public RegisterUser(event: any): void {
    event.preventDefault();
    const target = event.target;
    const first = target.querySelector('#first').value;
    const last = target.querySelector('#last').value;
    const email = target.querySelector('#email').value;
    const password = target.querySelector('#password').value;

    this.authService.PostRegist(new User(first, last, email, password))
      .subscribe(
        result => {
          this.router.navigate([""]);
        },
        () => { },
        () => { }
      );
    console.log(email, password);
  }

}
