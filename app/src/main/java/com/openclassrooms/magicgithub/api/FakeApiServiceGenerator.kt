package com.openclassrooms.magicgithub.api

import com.openclassrooms.magicgithub.model.User
import java.util.*

object FakeApiServiceGenerator {

    @JvmField
    var FAKE_USERS = mutableListOf(
        User("001", "Jake", "https://picsum.photos/50"),
        User("002", "Paul", "https://picsum.photos/50"),
        User("003", "Phil", "https://picsum.photos/50"),
        User("004", "Guillaume", "https://picsum.photos/50"),
        User("005", "Francis", "https://picsum.photos/50"),
        User("006", "George", "https://picsum.photos/50"),
        User("007", "Louis", "https://picsum.photos/50"),
        User("008", "Mateo", "https://picsum.photos/50"),
        User("009", "April", "https://picsum.photos/50"),
        User("010", "Louise", "https://picsum.photos/50"),
        User("011", "Elodie", "https://picsum.photos/50"),
        User("012", "Helene", "https://picsum.photos/50"),
        User("013", "Fanny", "https://picsum.photos/50"),
        User("014", "Laura", "https://picsum.photos/50"),
        User("015", "Gertrude", "https://picsum.photos/50"),
        User("016", "Chloé", "https://picsum.photos/50"),
        User("017", "April", "https://picsum.photos/50"),
        User("018", "Marie", "https://picsum.photos/50"),
        User("019", "Henri", "https://picsum.photos/50"),
        User("020", "Rémi", "https://picsum.photos/50")
    )

    @JvmField
    var FAKE_USERS_RANDOM = Arrays.asList(
        User("021", "Lea", "https://picsum.photos/50"),
        User("022", "Geoffrey", "https://picsum.photos/50"),
        User("023", "Simon", "https://picsum.photos/50"),
        User("024", "André", "https://picsum.photos/50"),
        User("025", "Leopold", "https://picsum.photos/50")
    )
}