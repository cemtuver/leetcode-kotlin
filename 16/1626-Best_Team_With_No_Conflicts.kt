class Solution {

    data class Player(val age: Int, val score: Int)

    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
        val n = scores.size
        val teamScores = IntArray(n) { 0 }
        val playerList = ages.mapIndexed { i, age -> Player(age, scores[i])}
            .sortedWith(compareBy({ it.age }, { it.score }))
            .toList()

        for (i in 0 until n) {
            teamScores[i] = playerList[i].score

            for (j in 0 until i) {
                if (playerList[j].score <= playerList[i].score) {
                    teamScores[i] = maxOf(teamScores[i], teamScores[j] + playerList[i].score)
                }
            }
        }

        return teamScores.max() ?: -1
    }

}