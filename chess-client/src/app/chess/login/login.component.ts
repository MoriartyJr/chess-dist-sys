import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { Login } from 'src/app/models/login';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { PlayerService } from 'src/app/service/player.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private player: User;

  public constructor(
    private readonly playerService: PlayerService,
    private readonly authService: AuthService,
    private readonly router: Router
  ) { }

  public ngOnInit(): void {
    this.playerService.currentPlayer.subscribe(player => this.player = player);
    if (this.player.GetEmail() != "") {
      this.router.navigate(['board']);      
    }
  }

  public LoginUser(event: any): void {
    event.preventDefault();
    const target = event.target;
    const email = target.querySelector('#email').value;
    const password = target.querySelector('#password').value;

    this.authService.GetUserDetails(new Login(email, password))
      .subscribe(
        result => {
          if (result) {
            this.player = result;
            this.playerService.loginPlayer(result);
            this.router.navigate(['board']);
          }
        },
        () => { },
        () => { }
      );
    console.log(email, password);
  }
}
