import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatsService {

  constructor(private httpClient: HttpClient) { }

  findcharacterPvpStats(nickname: string, characterId: string): Observable<RootObject>{
    return this.httpClient.get<RootObject>('http://localhost:8080/findplayer/' + nickname + '/pvpstats/' + characterId);
  }

  findcharacterPveStats(nickname: string, characterId: string) {
    return this.httpClient.get<RootObject>('http://localhost:8080/findplayer/' + nickname + '/pvestats/' + characterId);
  }
}

export interface CharacterActivityStats {
  averageAssists: number;
  averageDeaths: number;
  averageKills: number;
  averageKillsDeathsRatio: number;
}

export interface RootObject {
  characterActivityStats: CharacterActivityStats;
}

