package animation.constrainlayout.sample.com.sharedviewtransition.domain.datasource

import animation.constrainlayout.sample.com.sharedviewtransition.domain.model.Monkey

class MonkeyProvider() {
    private val monkeys = arrayListOf(
            Monkey(1,
                    "Baboon",
                    "Baboons are African and Arabian Old World monkeys belonging to the genus Papio, part of the subfamily Cercopithecinae.",
                    "Africa & Asia",
                    "http://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Portrait_Of_A_Baboon.jpg/314px-Portrait_Of_A_Baboon.jpg",
                    "http://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Portrait_Of_A_Baboon.jpg/314px-Portrait_Of_A_Baboon.jpg"),
            Monkey(2,
                    "Capuchin Monkey",
                    "The capuchin monkeys are New World monkeys of the subfamily Cebinae. Prior to 2011, the subfamily contained only a single genus, Cebus.",
                    "Central & South America",
                    "http://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Capuchin_Costa_Rica.jpg/200px-Capuchin_Costa_Rica.jpg",
                    "http://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Capuchin_Costa_Rica.jpg/200px-Capuchin_Costa_Rica.jpg"))


    fun getAll(): List<Monkey> {
        return monkeys
    }

    fun findById(id: Int): Monkey? {
        return monkeys.singleOrNull { monkey -> monkey.id == id }
    }
}