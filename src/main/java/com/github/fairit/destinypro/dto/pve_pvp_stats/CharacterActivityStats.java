package com.github.fairit.destinypro.dto.pve_pvp_stats;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CharacterActivityStats {

    private BigDecimal averageAssists;

    private BigDecimal averageDeaths;

    private BigDecimal averageKills;

    private BigDecimal averageKillsDeathsRatio;

    public BigDecimal getAverageAssists() {
        return averageAssists;
    }

    public void setAverageAssists(Double averageAssists) {
        this.averageAssists = new BigDecimal(averageAssists).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getAverageDeaths() {
        return averageDeaths;
    }

    public void setAverageDeaths(Double averageDeaths) {
        this.averageDeaths = new BigDecimal(averageDeaths).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getAverageKills() {
        return averageKills;
    }

    public void setAverageKills(Double averageKills) {
        this.averageKills = new BigDecimal(averageKills).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getAverageKillsDeathsRatio() {
        return averageKillsDeathsRatio;
    }

    public void setAverageKillsDeathsRatio(Double averageKillsDeathsRatio) {
        this.averageKillsDeathsRatio = new BigDecimal(averageKillsDeathsRatio).setScale(2, RoundingMode.HALF_UP);
    }
}
