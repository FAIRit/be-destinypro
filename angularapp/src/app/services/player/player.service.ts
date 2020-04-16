import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  playerNickname: string;

  constructor(private httpClient: HttpClient) {
  }

  public findPlayer(nickname: string): Observable<RootObject> {
    this.playerNickname = nickname;
    return this.httpClient.get<RootObject>('http://localhost:8080/findplayer/' + nickname);
  }
}

export interface CharacterGeneralStats {
  light: number;
  mobility: number;
  resilience: number;
  recovery: number;
  discipline: number;
  intellect: number;
  strength: number;
}

export interface CharacterDataList {
  membershipId: string;
  membershipType: number;
  characterId: string;
  raceName: string;
  genderName: string;
  className: string;
  light: number;
  characterGeneralStats: CharacterGeneralStats;
}

export interface RootObject {
  characterDataList: CharacterDataList[];
}

