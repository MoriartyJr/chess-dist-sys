import { Piece } from "./piece";

export class Board {
  [x: string]: any;
    
    public racks = 0;

    public files = 0;

    public id = 0;

    public tiles: Piece[][];

    public constructor() { };
}