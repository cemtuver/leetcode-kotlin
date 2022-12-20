class Solution {

    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = mutableSetOf<Int>()
        visit(rooms, visited, 0)

        return visited.size == rooms.size
    }

    private fun visit(rooms: List<List<Int>>, visited: MutableSet<Int>, room: Int) {
        visited.add(room)
        rooms[room].forEach { nextRoom ->
            if (!visited.contains(nextRoom)) {
                visit(rooms, visited, nextRoom)
            }
        }
    }

}