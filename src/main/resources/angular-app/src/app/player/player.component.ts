import {Component, OnInit} from '@angular/core';
import {CharacterDataList, PlayerService} from "../services/player/player.service";
import {CharacterActivityStats, StatsService} from "../services/stats/stats.service";

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  characters: CharacterDataList[];
  firstCharacterPvPStats: CharacterActivityStats;
  secondCharacterPvPStats: CharacterActivityStats;
  thirdCharacterPvPStats: CharacterActivityStats;
  firstCharacterPvEStats: CharacterActivityStats;
  secondCharacterPvEStats: CharacterActivityStats;
  thirdCharacterPvEStats: CharacterActivityStats;
  isShowStats = false;
  isShowPvP = false;
  isShowPvE = false;

  constructor(private playerService: PlayerService, private statsService: StatsService) {
  }

  ngOnInit(): void {

  }

  findPlayerCharactersByNickname(nickname: string) {
    this.playerService.findPlayer(nickname).subscribe(value => {
      this.characters = value.characterDataList;
    });
  }

  findFirstPlayerCharacterPvPStats(nickname: string, characterId: string) {
    this.toggleDisplayPvP()
    this.statsService.findcharacterPvpStats(nickname,characterId).subscribe(value => {
      this.firstCharacterPvPStats = value.characterActivityStats;
    });
  }

  findFirstPlayerCharacterPvEStats(nickname: string, characterId: string) {
    this.toggleDisplayPvE()
    this.statsService.findcharacterPveStats(nickname,characterId).subscribe(value => {
      this.firstCharacterPvEStats = value.characterActivityStats;
    });
  }

  findSecondPlayerCharacterPvPStats(nickname: string, characterId: string) {
    this.toggleDisplayPvP()
    this.statsService.findcharacterPvpStats(nickname,characterId).subscribe(value => {
      this.secondCharacterPvPStats = value.characterActivityStats;
    });
  }

  findSecondPlayerCharacterPvEStats(nickname: string, characterId: string) {
    this.toggleDisplayPvE()
    this.statsService.findcharacterPveStats(nickname,characterId).subscribe(value => {
      this.secondCharacterPvEStats = value.characterActivityStats;
    });
  }

  findThirdPlayerCharacterPvPStats(nickname: string, characterId: string) {
    this.toggleDisplayPvP()
    this.statsService.findcharacterPvpStats(nickname,characterId).subscribe(value => {
      this.thirdCharacterPvPStats = value.characterActivityStats;
    });
  }

  findThirdPlayerCharacterPvEStats(nickname: string, characterId: string) {
    this.toggleDisplayPvE()
    this.statsService.findcharacterPveStats(nickname,characterId).subscribe(value => {
      this.thirdCharacterPvEStats = value.characterActivityStats;
    });
  }

  toggleDisplayStats() {
    this.isShowStats = !this.isShowStats;
  }

  toggleDisplayPvP() {
    this.isShowPvP = !this.isShowPvP;
  }

  toggleDisplayPvE() {
    this.isShowPvE = !this.isShowPvE;
  }
}
