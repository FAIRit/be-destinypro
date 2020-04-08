import {Component, OnInit} from '@angular/core';
import {PlayerService, RootObject} from "../services/player/player.service";

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  rootObject: RootObject;

  constructor(private playerService: PlayerService) {
  }

  ngOnInit(): void {
    this.playerService.findPlayer().subscribe(value => {
      this.rootObject = value;
    });
  }
}
