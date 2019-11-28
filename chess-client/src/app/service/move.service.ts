import { Injectable } from '@angular/core';
import { RestService } from './rest.service';
import { Observable } from 'rxjs';
import { Move } from '../models/move';

@Injectable({
  providedIn: 'root'
})
export class MoveService {

  public constructor(private readonly restService: RestService) { }

  public PostMove(move: Move): Observable<boolean> {
    return this.restService.Post<boolean>("API/Move", move);
  }
}
