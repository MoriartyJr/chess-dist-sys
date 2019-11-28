import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { GetBoardQuery } from './queries/getboardquery';
import { RestService } from './rest.service';
import { Board } from '../models/board';

@Injectable({
  providedIn: 'root'
})
export class BoardService {

  public constructor(private readonly RestService: RestService) { }

  public GetBoard(): Observable<Board> {
    return this.RestService.Get<Board>("API/Board", new GetBoardQuery());
  }
}
