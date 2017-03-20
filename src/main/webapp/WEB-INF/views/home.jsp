<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Top 10 LoL Players</title>
<link rel="stylesheet" href="stylesheet.css">
</head>
<body>
	<div class="image">
		<div class="wrapper">
			<br />
			<h1>Top 10 Players</h1>
			<table>

				<tr>
					<th>Summoner Name</th>
					<th>Player Name</th>
					<th>Position</th>
					<th>Team</th>
				</tr>

				<c:forEach items="${playerList}" var="top10">
					<c:if test="${top10.summonerName!=player.summonerName}">
					${player.summonerName}
					
					<tr>
							<td class="left"><input type="radio" name="name"
								value="${ top10.summonerName}" /></td>
							<td>${top10.summonerName}</td>
							<td>${top10.playerName}</td>
							<td>${top10.position}</td>
							<td>${top10.team}</td>
							<td><form action="editPlayer.do">
									<button type="submit" name="Edit" value="${top10.summonerName}">
										Edit</button>
								</form></td>
							<td><form action="delete.do">
									<button type="submit" name="Delete"
										value="${top10.summonerName}">Delete Selected Items</button>
								</form></td>
						</tr>
					</c:if>
					<form action="edit.do">
						<c:if test="${top10.summonerName==player.summonerName}">

							<tr>
								<td><input type="hidden" name="summonerName"
									value="${top10.summonerName}" /></td>
								<td><input type="text" name="playerName"
									value="${top10.playerName}" /></td>
								<td><input type="text" name="position"
									value="${top10.position}" /></td>
								<td><input type="text" name="team" value="${top10.team}" /></td>
								<td>
									<button type="submit" name="Edit" value="${top10.summonerName}">
										Edit</button>
								</td>
							</tr>

						</c:if>
					</form>
				</c:forEach>
			</table>
		</div>
		<br /> <br />

		<div class="addFrom">
			<form action="CreateNew.do">
				<h3 style="color: white;">Add a Player</h3>
				<br /> <label>Summoner Name<input type="text"
					name="summonerName" /></label> <label>Summoner Name<input
					type="text" name="playerName" /></label> <label>Position<input
					type="text" name="position" /></label> <label>Team<input
					type="text" name="team" /></label> <input class="sumbit" type="submit"
					name="add" value="Add Player" />
			</form>
		</div>
	</div>
</body>
</html>