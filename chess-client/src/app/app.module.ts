import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { RestService } from './service/rest.service';
import { ChessBoardComponent } from './chess/chess-board/chess-board.component';
import { MovePipe } from './pipes/move.pipe';

import {
  MatCardModule,
  MatDialogModule,
  MatButtonModule,
  MatInputModule
} from '@angular/material';
import { LoginComponent } from './chess/login/login.component';
import { AdminComponent } from './chess/admin/admin.component';
import { RegistComponent } from './chess/regist/regist.component';

@NgModule({
  declarations: [
    AppComponent,
    ChessBoardComponent,
    MovePipe,
    LoginComponent,
    AdminComponent,
    RegistComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {
        path: 'board',
        component: ChessBoardComponent
      },
      {
        path: '',
        component: LoginComponent
      },
      {
        path: 'regist',
        component: RegistComponent
      },
      {
        path: 'admin',
        component: AdminComponent
      }
    ]),

    MatCardModule,
    MatDialogModule,
    MatButtonModule,
    MatInputModule
  ],
  providers: [
    RestService,
    MovePipe
  ],
  exports: [
    MatCardModule,
    MatDialogModule,
    MatButtonModule,
    MatInputModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
