import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  private sourcePlayer = new BehaviorSubject(new User("", "", "", ""));
  public currentPlayer = this.sourcePlayer.asObservable();

  public constructor() { }

  public loginPlayer(player: User) {
    this.sourcePlayer.next(player);
  }
}
