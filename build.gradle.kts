plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.quilt.loom)
}

group = properties["mod.maven.group"].toString()
version = "${properties["mod.version"]}+${libs.versions.minecraft.get()}"

base {
    archivesName.set(properties["mod.archives.base.name"].toString())
}

loom {
    mods {
        create("minecraft_riichi_mahjong") {
            sourceSet("main")
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    minecraft(libs.minecraft)
    mappings(
        variantOf(libs.quilt.mappings) {
            classifier("intermediary-v2")
        }
    )
    modImplementation(libs.bundles.quilt.kotlin)
    modImplementation(libs.quilt.loader)
    modImplementation(libs.quilted.fabric.api)

    runtimeOnly(kotlin("reflect"))

    testImplementation(kotlin("test"))
}

tasks.processResources {
    filesMatching("quilt.mod.json") {
        expand(properties)
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}