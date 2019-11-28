import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'move',
  pure: false
})
export class MovePipe implements PipeTransform {

  public transform(value: string): number {
    switch(value) {
      case "A1":
        return 0;
      case "A2":
        return 1;
      case "A3":
        return 2;
      case "A4":
        return 3;
      case "A5":
        return 4;
      case "A6":
        return 5;
      case "A7":
        return 6;
      case "A8":
        return 7;

      case "B1":
        return 8;
      case "B2":
        return 9;
      case "B3":
        return 10;
      case "B4":
        return 11;
      case "B5":
        return 12;
      case "B6":
        return 13;
      case "B7":
        return 14;
      case "B8":
        return 15;

      case "C1":
        return 16;
      case "C2":
        return 17;
      case "C3":
        return 18;
      case "C4":
        return 19;
      case "C5":
        return 20;
      case "C6":
        return 21;
      case "C7":
        return 22;
      case "C8":
        return 23;

      case "D1":
        return 24;
      case "D2":
        return 25;
      case "D3":
        return 26;
      case "D4":
        return 27;
      case "D5":
        return 28;
      case "D6":
        return 29;
      case "D7":
        return 30;
      case "D8":
        return 31;

      case "E1":
        return 32;
      case "E2":
        return 33;
      case "E3":
        return 34;
      case "E4":
        return 35;
      case "E5":
        return 36;
      case "E6":
        return 37;
      case "E7":
        return 38;
      case "E8":
        return 39;

      case "F1":
        return 40;
      case "F2":
        return 41;
      case "F3":
        return 42;
      case "F4":
        return 43;
      case "F5":
        return 44;
      case "F6":
        return 45;
      case "F7":
        return 46;
      case "F8":
        return 47;

      case "G1":
        return 48;
      case "G2":
        return 49;
      case "G3":
        return 50;
      case "G4":
        return 51;
      case "G5":
        return 52;
      case "G6":
        return 53;
      case "G7":
        return 54;
      case "G8":
        return 55;

      case "H1":
        return 56;
      case "H2":
        return 57;
      case "H3":
        return 58;
      case "H4":
        return 59;
      case "H5":
        return 60;
      case "H6":
        return 61;
      case "H7":
        return 62;
      case "H8":
        return 63;
    }
  }

}
