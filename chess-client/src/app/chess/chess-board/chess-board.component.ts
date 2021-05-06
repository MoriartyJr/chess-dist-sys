import { Component, OnInit } from '@angular/core';
import { Board } from 'src/app/models/board';
import { BoardService } from 'src/app/service/board.service';
import { MoveService } from 'src/app/service/move.service';
import { Move } from 'src/app/models/move';
import { MovePipe } from 'src/app/pipes/move.pipe';
import { PlayerService } from 'src/app/service/player.service';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'chess-board',
  templateUrl: './chess-board.component.html',
  styleUrls: ['./chess-board.component.css']
})
export class ChessBoardComponent implements OnInit {
  private origin: string;
  private destination: string;
  
  public board: Board = new Board();
  public Player: User = new User("", "", "", "");
  public MoveSelected: boolean = false;
  public MovePreview: string = "";
  public NotAllowedDialog: string = "";

  public constructor(
    private readonly playerService: PlayerService,
    private readonly boardService: BoardService,
    private readonly moveService: MoveService,
    private readonly movePipe: MovePipe,
    private readonly router: Router
    ) { }

  public ngOnInit(): void {
    this.playerService.currentPlayer.subscribe(
      player => {
        this.Player = player;
        this.updateBoard(true);
      },
      () => {},
      () => {}
    )
  }

  private updateBoard(allowed: boolean) {
    if (!allowed) {
      this.openNotAllowedDialog();
      return;
    }
    this.NotAllowedDialog = "";
    this.destination = null;
    this.origin = null;
    this.MovePreview = "";

    this.boardService.GetBoard()
      .subscribe(
        result => { this.board = result; },
        () => { },
        () => { });
  }
  private openNotAllowedDialog(): void {
    this.destination = null;
    this.origin = null;
    this.MovePreview = "";
    this.NotAllowedDialog = "Your move is not allowed! Try again...";
  }

  public SelectPiece(position: string): void {
    if (this.destination) {
      return;
    }
    else if (!this.origin) {
      this.origin = position;
      this.MovePreview += "Your move is: " + this.origin + " to ";
    }
    else {
      this.destination = position;
      this.MovePreview += this.destination + " do you want to confirm this?"
      this.MoveSelected = true;
    }
  }

  private isPieceOnSquare(position: string): boolean {
    var X = position.charAt(0);
    var Y = position.charAt(1);

    var positionX = this.convertXtoNumber(X);
    var positionY = Number(Y);

    var z = this.board.tiles[positionX][positionY] != null ? true : false;
    return z;
  }

  private convertXtoNumber(X: string): number {
    switch (X) {
      case "A":
        return 0;
      case "B":
        return 1;
      case "C":
        return 2;
      case "D":
        return 3;
      case "E":
        return 4;
      case "F":
        return 5;
      case "G":
        return 6;
      case "H":
        return 7;
      default:
        break;
    }
  }

  public SendMove(): void {
    var move = new Move(this.movePipe.transform(this.origin), this.movePipe.transform(this.destination));

    this.moveService.PostMove(move)
      .subscribe(
        result => {
          this.updateBoard(result);
        },
        () => { },
        () => { }
      )
  }

  public ResetMove(): void {
    this.destination = null;
    this.origin = null;
    this.MovePreview = "";
  }
}