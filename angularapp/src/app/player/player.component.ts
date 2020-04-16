import {Component, OnInit} from '@angular/core';
import {CharacterActivityStats, StatsService} from '../services/stats/stats.service';
import {CharacterDataList, PlayerService} from '../services/player/player.service';

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
  isShowFirstStats = false;
  isShowSecondStats = false;
  isShowThirdStats = false;
  isShowFirstPvP = false;
  isShowSecondPvP = false;
  isShowThirdPvP = false;
  isShowFirstPvE = false;
  isShowSecondPvE = false;
  isShowThirdPvE = false;

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
    this.statsService.findcharacterPvpStats(nickname, characterId).subscribe(value => {
      this.firstCharacterPvPStats = value.characterActivityStats;
    });
    this.toggleDisplayFirstPvP();
  }

  findFirstPlayerCharacterPvEStats(nickname: string, characterId: string) {
    this.statsService.findcharacterPveStats(nickname, characterId).subscribe(value => {
      this.firstCharacterPvEStats = value.characterActivityStats;
    });
    this.toggleDisplayFirstPvE();
  }

  findSecondPlayerCharacterPvPStats(nickname: string, characterId: string) {
    this.statsService.findcharacterPvpStats(nickname, characterId).subscribe(value => {
      this.secondCharacterPvPStats = value.characterActivityStats;
    });
    this.toggleDisplaySecondPvP();
  }

  findSecondPlayerCharacterPvEStats(nickname: string, characterId: string) {
    this.statsService.findcharacterPveStats(nickname, characterId).subscribe(value => {
      this.secondCharacterPvEStats = value.characterActivityStats;
    });
    this.toggleDisplaySecondPvE();
  }

  findThirdPlayerCharacterPvPStats(nickname: string, characterId: string) {
    this.statsService.findcharacterPvpStats(nickname, characterId).subscribe(value => {
      this.thirdCharacterPvPStats = value.characterActivityStats;
    });
    this.toggleDisplayThirdPvP();
  }

  findThirdPlayerCharacterPvEStats(nickname: string, characterId: string) {
    this.statsService.findcharacterPveStats(nickname, characterId).subscribe(value => {
      this.thirdCharacterPvEStats = value.characterActivityStats;
    });
    this.toggleDisplayThirdPvE();
  }

  toggleDisplayFirstStats() {
    this.isShowFirstStats = !this.isShowFirstStats;
  }

  toggleDisplaySecondStats() {
    this.isShowSecondStats = !this.isShowSecondStats;
  }

  toggleDisplayThirdStats() {
    this.isShowThirdStats = !this.isShowThirdStats;
  }

  toggleDisplayFirstPvP() {
    this.isShowFirstPvP = !this.isShowFirstPvP;
  }

  toggleDisplaySecondPvP() {
    this.isShowSecondPvP = !this.isShowSecondPvP;
  }

  toggleDisplayThirdPvP() {
    this.isShowThirdPvP = !this.isShowThirdPvP;
  }

  toggleDisplayFirstPvE() {
    this.isShowFirstPvE = !this.isShowFirstPvE;
  }

  toggleDisplaySecondPvE() {
    this.isShowSecondPvE = !this.isShowSecondPvE;
  }

  toggleDisplayThirdPvE() {
    this.isShowThirdPvE = !this.isShowThirdPvE;
  }
}
