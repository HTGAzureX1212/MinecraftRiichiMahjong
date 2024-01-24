pluginManagement {
    repositories {
        maven {
            name = "Quilt"
            setUrl("https://maven.quiltmc.org/repository/release")
        }
        // Currently needed for Intermediary and other temporary dependencies
        maven {
            name = "Fabric"
            setUrl("https://maven.fabricmc.net/")
        }
        gradlePluginPortal()
    }
}

rootProject.name = "MinecraftRiichiMahjong"

