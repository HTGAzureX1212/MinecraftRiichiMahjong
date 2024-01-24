plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.quilt.loom)
}

base {
    archivesName.set(properties["mod.archives.base.name"].toString())
}

group = properties["mod.maven.group"].toString()
version = "${properties["mod.version"]}+${libs.versions.minecraft.get()}"

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
    modImplementation(libs.quilt.loader)
    modImplementation(libs.quilted.fabric.api)

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
