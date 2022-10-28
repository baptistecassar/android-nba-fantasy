package com.bcassar.sharedtest

import com.bcassar.data.local.entity.GameEntity
import com.bcassar.data.local.entity.TeamEntity

/**
 * Created by bcassar on 27/10/2022
 */
val lakers = TeamEntity(
    teamID = 1610612747,
    teamName = "Lakers",
    teamCity = "Los Angeles",
    teamTricode = "LAL",
    teamSlug = "lakers",
    wins = 0,
    losses = 3,
)

val blazers = TeamEntity(
    teamID = 1610612757,
    teamName = "Trail Blazers",
    teamCity = "Portland",
    teamTricode = "POR",
    teamSlug = "blazers",
    wins = 3,
    losses = 0,
)

val game = GameEntity(
    gameId = "0022200037",
    gameCode = "20221023/PORLAL",
    gameStatus = 3,
    gameStatusText = "Final",
    period = 4,
    gameClock = "",
    gameTimeUTC = "2022-10-23T19:30:00Z",
    homeTeamId = 1610612747,
    awayTeamId = 1610612757,
    homeTeamScore = 104,
    awayTeamScore = 106,
)
val scoreboardResponse =
    "{\"meta\": {\"version\": 1, \"request\": \"http://nba.cloud/league/00/2022/10/23/scoreboard?Format=json\", \"time\": \"2022-10-27T04:52:39.5239Z\"}, \"scoreboard\": {\"gameDate\": \"2022-10-23\", \"leagueId\": \"00\", \"leagueName\": \"National Basketball Association\", \"games\": [   {   \"gameId\": \"0022200037\",   \"gameCode\": \"20221023/PORLAL\",   \"gameStatus\": 3,   \"gameStatusText\": \"Final\",   \"period\": 4,   \"gameClock\": \"\",   \"gameTimeUTC\": \"2022-10-23T19:30:00Z\",   \"gameEt\": \"2022-10-23T15:30:00Z\",   \"regulationPeriods\": 4,   \"seriesGameNumber\": \"\",   \"seriesText\": \"\",   \"ifNecessary\": false,   \"gameLeaders\": {   \"homeLeaders\": {   \"personId\": 2544,   \"name\": \"LeBron James\",   \"playerSlug\": \"lebron-james\",   \"jerseyNum\": \"6\",   \"position\": \"F\",   \"teamTricode\": \"LAL\",   \"points\": 31,   \"rebounds\": 8,   \"assists\": 8 },   \"awayLeaders\": {   \"personId\": 203081,   \"name\": \"Damian Lillard\",   \"playerSlug\": \"damian-lillard\",   \"jerseyNum\": \"0\",   \"position\": \"G\",   \"teamTricode\": \"POR\",   \"points\": 41,   \"rebounds\": 5,   \"assists\": 2 } },   \"teamLeaders\": {   \"homeLeaders\": {   \"personId\": 2544,   \"name\": \"LeBron James\",   \"playerSlug\": \"lebron-james\",   \"jerseyNum\": \"6\",   \"position\": \"F\",   \"teamTricode\": \"LAL\",   \"points\": 25.3,   \"rebounds\": 10.0,   \"assists\": 7.8 },   \"awayLeaders\": {   \"personId\": 203081,   \"name\": \"Damian Lillard\",   \"playerSlug\": \"damian-lillard\",   \"jerseyNum\": \"0\",   \"position\": \"G\",   \"teamTricode\": \"POR\",   \"points\": 31.0,   \"rebounds\": 4.8,   \"assists\": 4.6 },   \"seasonLeadersFlag\": 0 },   \"broadcasters\": {   \"nationalBroadcasters\": [],   \"homeTvBroadcasters\": [   {   \"broadcasterId\": 1651,   \"broadcastDisplay\": \"SPECSN\" } ],   \"homeRadioBroadcasters\": [   {   \"broadcasterId\": 1000286,   \"broadcastDisplay\": \"KSPN/KWKW-LAL\" } ],   \"awayTvBroadcasters\": [   {   \"broadcasterId\": 1000709,   \"broadcastDisplay\": \"ROOT-SP+\" } ],   \"awayRadioBroadcasters\": [   {   \"broadcasterId\": 1472,   \"broadcastDisplay\": \"KPOJ\" } ] },   \"homeTeam\": {   \"teamId\": 1610612747,   \"teamName\": \"Lakers\",   \"teamCity\": \"Los Angeles\",   \"teamTricode\": \"LAL\",   \"teamSlug\": \"lakers\",   \"wins\": 0,   \"losses\": 3,   \"score\": 104,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 0,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 24 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 24 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 35 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 21 } ] },   \"awayTeam\": {   \"teamId\": 1610612757,   \"teamName\": \"Trail Blazers\",   \"teamCity\": \"Portland\",   \"teamTricode\": \"POR\",   \"teamSlug\": \"blazers\",   \"wins\": 3,   \"losses\": 0,   \"score\": 106,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 0,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 32 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 23 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 23 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 28 } ] } },   {   \"gameId\": \"0022200038\",   \"gameCode\": \"20221023/CHAATL\",   \"gameStatus\": 3,   \"gameStatusText\": \"Final\",   \"period\": 4,   \"gameClock\": \"\",   \"gameTimeUTC\": \"2022-10-23T21:00:00Z\",   \"gameEt\": \"2022-10-23T17:00:00Z\",   \"regulationPeriods\": 4,   \"seriesGameNumber\": \"\",   \"seriesText\": \"\",   \"ifNecessary\": false,   \"gameLeaders\": {   \"homeLeaders\": {   \"personId\": 1629027,   \"name\": \"Trae Young\",   \"playerSlug\": \"trae-young\",   \"jerseyNum\": \"11\",   \"position\": \"G\",   \"teamTricode\": \"ATL\",   \"points\": 28,   \"rebounds\": 5,   \"assists\": 9 },   \"awayLeaders\": {   \"personId\": 1626162,   \"name\": \"Kelly Oubre Jr.\",   \"playerSlug\": \"kelly-oubre-jr\",   \"jerseyNum\": \"12\",   \"position\": \"F-G\",   \"teamTricode\": \"CHA\",   \"points\": 24,   \"rebounds\": 10,   \"assists\": 0 } },   \"teamLeaders\": {   \"homeLeaders\": {   \"personId\": 1629027,   \"name\": \"Trae Young\",   \"playerSlug\": \"trae-young\",   \"jerseyNum\": \"11\",   \"position\": \"G\",   \"teamTricode\": \"ATL\",   \"points\": 27.8,   \"rebounds\": 3.8,   \"assists\": 10.3 },   \"awayLeaders\": {   \"personId\": 202330,   \"name\": \"Gordon Hayward\",   \"playerSlug\": \"gordon-hayward\",   \"jerseyNum\": \"20\",   \"position\": \"F\",   \"teamTricode\": \"CHA\",   \"points\": 19.8,   \"rebounds\": 4.8,   \"assists\": 4.5 },   \"seasonLeadersFlag\": 0 },   \"broadcasters\": {   \"nationalBroadcasters\": [],   \"homeTvBroadcasters\": [   {   \"broadcasterId\": 1000356,   \"broadcastDisplay\": \"BSSE-ATL\" } ],   \"homeRadioBroadcasters\": [   {   \"broadcasterId\": 1525,   \"broadcastDisplay\": \"WVEE\" } ],   \"awayTvBroadcasters\": [   {   \"broadcasterId\": 1000357,   \"broadcastDisplay\": \"BSSE-CHA\" } ],   \"awayRadioBroadcasters\": [   {   \"broadcasterId\": 1000862,   \"broadcastDisplay\": \"WFNZ-FM\" } ] },   \"homeTeam\": {   \"teamId\": 1610612737,   \"teamName\": \"Hawks\",   \"teamCity\": \"Atlanta\",   \"teamTricode\": \"ATL\",   \"teamSlug\": \"hawks\",   \"wins\": 2,   \"losses\": 1,   \"score\": 109,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 1,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 30 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 25 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 29 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 25 } ] },   \"awayTeam\": {   \"teamId\": 1610612766,   \"teamName\": \"Hornets\",   \"teamCity\": \"Charlotte\",   \"teamTricode\": \"CHA\",   \"teamSlug\": \"hornets\",   \"wins\": 2,   \"losses\": 1,   \"score\": 126,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 0,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 22 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 37 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 45 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 22 } ] } },   {   \"gameId\": \"0022200039\",   \"gameCode\": \"20221023/WASCLE\",   \"gameStatus\": 3,   \"gameStatusText\": \"Final/OT\",   \"period\": 5,   \"gameClock\": \"\",   \"gameTimeUTC\": \"2022-10-23T23:00:00Z\",   \"gameEt\": \"2022-10-23T19:00:00Z\",   \"regulationPeriods\": 4,   \"seriesGameNumber\": \"\",   \"seriesText\": \"\",   \"ifNecessary\": false,   \"gameLeaders\": {   \"homeLeaders\": {   \"personId\": 1628378,   \"name\": \"Donovan Mitchell\",   \"playerSlug\": \"donovan-mitchell\",   \"jerseyNum\": \"45\",   \"position\": \"G\",   \"teamTricode\": \"CLE\",   \"points\": 37,   \"rebounds\": 5,   \"assists\": 4 },   \"awayLeaders\": {   \"personId\": 203078,   \"name\": \"Bradley Beal\",   \"playerSlug\": \"bradley-beal\",   \"jerseyNum\": \"3\",   \"position\": \"G\",   \"teamTricode\": \"WAS\",   \"points\": 27,   \"rebounds\": 4,   \"assists\": 5 } },   \"teamLeaders\": {   \"homeLeaders\": {   \"personId\": 1628378,   \"name\": \"Donovan Mitchell\",   \"playerSlug\": \"donovan-mitchell\",   \"jerseyNum\": \"45\",   \"position\": \"G\",   \"teamTricode\": \"CLE\",   \"points\": 28.5,   \"rebounds\": 5.0,   \"assists\": 7.3 },   \"awayLeaders\": {   \"personId\": 203078,   \"name\": \"Bradley Beal\",   \"playerSlug\": \"bradley-beal\",   \"jerseyNum\": \"3\",   \"position\": \"G\",   \"teamTricode\": \"WAS\",   \"points\": 20.5,   \"rebounds\": 3.5,   \"assists\": 6.3 },   \"seasonLeadersFlag\": 0 },   \"broadcasters\": {   \"nationalBroadcasters\": [   {   \"broadcasterId\": 7,   \"broadcastDisplay\": \"NBA TV\" } ],   \"homeTvBroadcasters\": [   {   \"broadcasterId\": 1000358,   \"broadcastDisplay\": \"BSOH\" } ],   \"homeRadioBroadcasters\": [   {   \"broadcasterId\": 1000258,   \"broadcastDisplay\": \"WTAM/WMMS/WNZN\" } ],   \"awayTvBroadcasters\": [   {   \"broadcasterId\": 1660,   \"broadcastDisplay\": \"NBCSWA\" } ],   \"awayRadioBroadcasters\": [   {   \"broadcasterId\": 1139,   \"broadcastDisplay\": \"WTEM\" } ] },   \"homeTeam\": {   \"teamId\": 1610612739,   \"teamName\": \"Cavaliers\",   \"teamCity\": \"Cleveland\",   \"teamTricode\": \"CLE\",   \"teamSlug\": \"cavaliers\",   \"wins\": 2,   \"losses\": 1,   \"score\": 117,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 1,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 30 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 27 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 26 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 20 },   {   \"period\": 5,   \"periodType\": \"OVERTIME\",   \"score\": 14 } ] },   \"awayTeam\": {   \"teamId\": 1610612764,   \"teamName\": \"Wizards\",   \"teamCity\": \"Washington\",   \"teamTricode\": \"WAS\",   \"teamSlug\": \"wizards\",   \"wins\": 2,   \"losses\": 1,   \"score\": 107,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 0,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 31 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 20 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 25 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 27 },   {   \"period\": 5,   \"periodType\": \"OVERTIME\",   \"score\": 4 } ] } },   {   \"gameId\": \"0022200040\",   \"gameCode\": \"20221023/UTANOP\",   \"gameStatus\": 3,   \"gameStatusText\": \"Final/OT\",   \"period\": 5,   \"gameClock\": \"\",   \"gameTimeUTC\": \"2022-10-23T23:00:00Z\",   \"gameEt\": \"2022-10-23T19:00:00Z\",   \"regulationPeriods\": 4,   \"seriesGameNumber\": \"\",   \"seriesText\": \"\",   \"ifNecessary\": false,   \"gameLeaders\": {   \"homeLeaders\": {   \"personId\": 203468,   \"name\": \"CJ McCollum\",   \"playerSlug\": \"cj-mccollum\",   \"jerseyNum\": \"3\",   \"position\": \"G\",   \"teamTricode\": \"NOP\",   \"points\": 28,   \"rebounds\": 4,   \"assists\": 12 },   \"awayLeaders\": {   \"personId\": 1628374,   \"name\": \"Lauri Markkanen\",   \"playerSlug\": \"lauri-markkanen\",   \"jerseyNum\": \"23\",   \"position\": \"F-C\",   \"teamTricode\": \"UTA\",   \"points\": 31,   \"rebounds\": 12,   \"assists\": 2 } },   \"teamLeaders\": {   \"homeLeaders\": {   \"personId\": 203468,   \"name\": \"CJ McCollum\",   \"playerSlug\": \"cj-mccollum\",   \"jerseyNum\": \"3\",   \"position\": \"G\",   \"teamTricode\": \"NOP\",   \"points\": 21.0,   \"rebounds\": 3.5,   \"assists\": 7.8 },   \"awayLeaders\": {   \"personId\": 1628374,   \"name\": \"Lauri Markkanen\",   \"playerSlug\": \"lauri-markkanen\",   \"jerseyNum\": \"23\",   \"position\": \"F-C\",   \"teamTricode\": \"UTA\",   \"points\": 22.0,   \"rebounds\": 8.8,   \"assists\": 3.0 },   \"seasonLeadersFlag\": 0 },   \"broadcasters\": {   \"nationalBroadcasters\": [],   \"homeTvBroadcasters\": [   {   \"broadcasterId\": 1000346,   \"broadcastDisplay\": \"BSNO\" } ],   \"homeRadioBroadcasters\": [   {   \"broadcasterId\": 1552,   \"broadcastDisplay\": \"WRNO\" } ],   \"awayTvBroadcasters\": [   {   \"broadcasterId\": 1659,   \"broadcastDisplay\": \"ATTSN-RM\" } ],   \"awayRadioBroadcasters\": [   {   \"broadcasterId\": 1000274,   \"broadcastDisplay\": \"KZNS/KTUB\" } ] },   \"homeTeam\": {   \"teamId\": 1610612740,   \"teamName\": \"Pelicans\",   \"teamCity\": \"New Orleans\",   \"teamTricode\": \"NOP\",   \"teamSlug\": \"pelicans\",   \"wins\": 2,   \"losses\": 1,   \"score\": 121,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 0,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 24 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 29 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 31 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 26 },   {   \"period\": 5,   \"periodType\": \"OVERTIME\",   \"score\": 11 } ] },   \"awayTeam\": {   \"teamId\": 1610612762,   \"teamName\": \"Jazz\",   \"teamCity\": \"Utah\",   \"teamTricode\": \"UTA\",   \"teamSlug\": \"jazz\",   \"wins\": 3,   \"losses\": 0,   \"score\": 122,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 0,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 26 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 37 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 30 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 17 },   {   \"period\": 5,   \"periodType\": \"OVERTIME\",   \"score\": 12 } ] } },   {   \"gameId\": \"0022200041\",   \"gameCode\": \"20221023/MINOKC\",   \"gameStatus\": 3,   \"gameStatusText\": \"Final\",   \"period\": 4,   \"gameClock\": \"\",   \"gameTimeUTC\": \"2022-10-24T00:00:00Z\",   \"gameEt\": \"2022-10-23T20:00:00Z\",   \"regulationPeriods\": 4,   \"seriesGameNumber\": \"\",   \"seriesText\": \"\",   \"ifNecessary\": false,   \"gameLeaders\": {   \"homeLeaders\": {   \"personId\": 1629652,   \"name\": \"Luguentz Dort\",   \"playerSlug\": \"luguentz-dort\",   \"jerseyNum\": \"5\",   \"position\": \"G\",   \"teamTricode\": \"OKC\",   \"points\": 20,   \"rebounds\": 3,   \"assists\": 2 },   \"awayLeaders\": {   \"personId\": 1630162,   \"name\": \"Anthony Edwards\",   \"playerSlug\": \"anthony-edwards\",   \"jerseyNum\": \"1\",   \"position\": \"G\",   \"teamTricode\": \"MIN\",   \"points\": 30,   \"rebounds\": 11,   \"assists\": 3 } },   \"teamLeaders\": {   \"homeLeaders\": {   \"personId\": 1628983,   \"name\": \"Shai Gilgeous-Alexander\",   \"playerSlug\": \"shai-gilgeous-alexander\",   \"jerseyNum\": \"2\",   \"position\": \"G\",   \"teamTricode\": \"OKC\",   \"points\": 31.0,   \"rebounds\": 4.7,   \"assists\": 6.7 },   \"awayLeaders\": {   \"personId\": 1630162,   \"name\": \"Anthony Edwards\",   \"playerSlug\": \"anthony-edwards\",   \"jerseyNum\": \"1\",   \"position\": \"G\",   \"teamTricode\": \"MIN\",   \"points\": 22.8,   \"rebounds\": 7.4,   \"assists\": 4.6 },   \"seasonLeadersFlag\": 0 },   \"broadcasters\": {   \"nationalBroadcasters\": [],   \"homeTvBroadcasters\": [   {   \"broadcasterId\": 1000345,   \"broadcastDisplay\": \"BSOK\" } ],   \"homeRadioBroadcasters\": [   {   \"broadcasterId\": 1574,   \"broadcastDisplay\": \"WWLS/WKY\" } ],   \"awayTvBroadcasters\": [   {   \"broadcasterId\": 1000347,   \"broadcastDisplay\": \"BSN\" } ],   \"awayRadioBroadcasters\": [   {   \"broadcasterId\": 1380,   \"broadcastDisplay\": \"WCCO\" } ] },   \"homeTeam\": {   \"teamId\": 1610612760,   \"teamName\": \"Thunder\",   \"teamCity\": \"Oklahoma City\",   \"teamTricode\": \"OKC\",   \"teamSlug\": \"thunder\",   \"wins\": 0,   \"losses\": 3,   \"score\": 106,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 0,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 18 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 26 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 30 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 32 } ] },   \"awayTeam\": {   \"teamId\": 1610612750,   \"teamName\": \"Timberwolves\",   \"teamCity\": \"Minnesota\",   \"teamTricode\": \"MIN\",   \"teamSlug\": \"timberwolves\",   \"wins\": 2,   \"losses\": 1,   \"score\": 116,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 1,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 31 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 22 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 29 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 34 } ] } },   {   \"gameId\": \"0022200042\",   \"gameCode\": \"20221023/SACGSW\",   \"gameStatus\": 3,   \"gameStatusText\": \"Final\",   \"period\": 4,   \"gameClock\": \"\",   \"gameTimeUTC\": \"2022-10-24T00:30:00Z\",   \"gameEt\": \"2022-10-23T20:30:00Z\",   \"regulationPeriods\": 4,   \"seriesGameNumber\": \"\",   \"seriesText\": \"\",   \"ifNecessary\": false,   \"gameLeaders\": {   \"homeLeaders\": {   \"personId\": 201939,   \"name\": \"Stephen Curry\",   \"playerSlug\": \"stephen-curry\",   \"jerseyNum\": \"30\",   \"position\": \"G\",   \"teamTricode\": \"GSW\",   \"points\": 33,   \"rebounds\": 5,   \"assists\": 2 },   \"awayLeaders\": {   \"personId\": 1628368,   \"name\": \"De'Aaron Fox\",   \"playerSlug\": \"deaaron-fox\",   \"jerseyNum\": \"5\",   \"position\": \"G\",   \"teamTricode\": \"SAC\",   \"points\": 26,   \"rebounds\": 5,   \"assists\": 10 } },   \"teamLeaders\": {   \"homeLeaders\": {   \"personId\": 201939,   \"name\": \"Stephen Curry\",   \"playerSlug\": \"stephen-curry\",   \"jerseyNum\": \"30\",   \"position\": \"G\",   \"teamTricode\": \"GSW\",   \"points\": 30.3,   \"rebounds\": 5.8,   \"assists\": 5.3 },   \"awayLeaders\": {   \"personId\": 1628368,   \"name\": \"De'Aaron Fox\",   \"playerSlug\": \"deaaron-fox\",   \"jerseyNum\": \"5\",   \"position\": \"G\",   \"teamTricode\": \"SAC\",   \"points\": 31.7,   \"rebounds\": 5.7,   \"assists\": 7.0 },   \"seasonLeadersFlag\": 0 },   \"broadcasters\": {   \"nationalBroadcasters\": [],   \"homeTvBroadcasters\": [   {   \"broadcasterId\": 1097,   \"broadcastDisplay\": \"NBCSBA\" } ],   \"homeRadioBroadcasters\": [   {   \"broadcasterId\": 1597,   \"broadcastDisplay\": \"KGMZ-FM\" } ],   \"awayTvBroadcasters\": [   {   \"broadcasterId\": 1027,   \"broadcastDisplay\": \"NBCSCA\" } ],   \"awayRadioBroadcasters\": [   {   \"broadcasterId\": 1052,   \"broadcastDisplay\": \"KHTK\" } ] },   \"homeTeam\": {   \"teamId\": 1610612744,   \"teamName\": \"Warriors\",   \"teamCity\": \"Golden State\",   \"teamTricode\": \"GSW\",   \"teamSlug\": \"warriors\",   \"wins\": 2,   \"losses\": 1,   \"score\": 130,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 0,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 39 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 50 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 24 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 17 } ] },   \"awayTeam\": {   \"teamId\": 1610612758,   \"teamName\": \"Kings\",   \"teamCity\": \"Sacramento\",   \"teamTricode\": \"SAC\",   \"teamSlug\": \"kings\",   \"wins\": 0,   \"losses\": 3,   \"score\": 125,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 0,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 36 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 35 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 23 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 31 } ] } },   {   \"gameId\": \"0022200043\",   \"gameCode\": \"20221023/PHXLAC\",   \"gameStatus\": 3,   \"gameStatusText\": \"Final\",   \"period\": 4,   \"gameClock\": \"\",   \"gameTimeUTC\": \"2022-10-24T02:00:00Z\",   \"gameEt\": \"2022-10-23T22:00:00Z\",   \"regulationPeriods\": 4,   \"seriesGameNumber\": \"\",   \"seriesText\": \"\",   \"ifNecessary\": false,   \"gameLeaders\": {   \"homeLeaders\": {   \"personId\": 202694,   \"name\": \"Marcus Morris Sr.\",   \"playerSlug\": \"marcus-morris-sr\",   \"jerseyNum\": \"8\",   \"position\": \"F\",   \"teamTricode\": \"LAC\",   \"points\": 22,   \"rebounds\": 5,   \"assists\": 1 },   \"awayLeaders\": {   \"personId\": 1626164,   \"name\": \"Devin Booker\",   \"playerSlug\": \"devin-booker\",   \"jerseyNum\": \"1\",   \"position\": \"G\",   \"teamTricode\": \"PHX\",   \"points\": 35,   \"rebounds\": 1,   \"assists\": 4 } },   \"teamLeaders\": {   \"homeLeaders\": {   \"personId\": 202331,   \"name\": \"Paul George\",   \"playerSlug\": \"paul-george\",   \"jerseyNum\": \"13\",   \"position\": \"F\",   \"teamTricode\": \"LAC\",   \"points\": 23.7,   \"rebounds\": 7.7,   \"assists\": 4.7 },   \"awayLeaders\": {   \"personId\": 1626164,   \"name\": \"Devin Booker\",   \"playerSlug\": \"devin-booker\",   \"jerseyNum\": \"1\",   \"position\": \"G\",   \"teamTricode\": \"PHX\",   \"points\": 32.5,   \"rebounds\": 3.0,   \"assists\": 5.8 },   \"seasonLeadersFlag\": 0 },   \"broadcasters\": {   \"nationalBroadcasters\": [   {   \"broadcasterId\": 7,   \"broadcastDisplay\": \"NBA TV\" } ],   \"homeTvBroadcasters\": [   {   \"broadcasterId\": 1000363,   \"broadcastDisplay\": \"BSSC\" },   {   \"broadcasterId\": 1000874,   \"broadcastDisplay\": \"ClipperVision\" } ],   \"homeRadioBroadcasters\": [   {   \"broadcasterId\": 1000288,   \"broadcastDisplay\": \"KLAC/KWKW-LAC\" } ],   \"awayTvBroadcasters\": [   {   \"broadcasterId\": 1000336,   \"broadcastDisplay\": \"BSAZ\" } ],   \"awayRadioBroadcasters\": [   {   \"broadcasterId\": 1598,   \"broadcastDisplay\": \"KMVP/KSUN\" } ] },   \"homeTeam\": {   \"teamId\": 1610612746,   \"teamName\": \"Clippers\",   \"teamCity\": \"LA\",   \"teamTricode\": \"LAC\",   \"teamSlug\": \"clippers\",   \"wins\": 2,   \"losses\": 1,   \"score\": 95,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 0,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 18 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 23 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 31 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 23 } ] },   \"awayTeam\": {   \"teamId\": 1610612756,   \"teamName\": \"Suns\",   \"teamCity\": \"Phoenix\",   \"teamTricode\": \"PHX\",   \"teamSlug\": \"suns\",   \"wins\": 2,   \"losses\": 1,   \"score\": 112,   \"seed\": 0,   \"inBonus\": null,   \"timeoutsRemaining\": 1,   \"periods\": [   {   \"period\": 1,   \"periodType\": \"REGULAR\",   \"score\": 33 },   {   \"period\": 2,   \"periodType\": \"REGULAR\",   \"score\": 28 },   {   \"period\": 3,   \"periodType\": \"REGULAR\",   \"score\": 25 },   {   \"period\": 4,   \"periodType\": \"REGULAR\",   \"score\": 26 } ] } } ] }}"