package com.theapache64.gitlabcli

import org.apache.commons.cli.*

val helpFormatter by lazy { HelpFormatter() }
val parser = DefaultParser()
val options = Options().apply {
    addOption("i", "issues", false, "To list all open issues")
    addOption("h", "help", false, "To print help text")
}

fun main(args: Array<String>) {

    val cli = parser.parse(options, args)

    when {
        cli.hasOption("h") -> printHelp()
        cli.hasOption("i") -> {
            
        }
        else -> printError()
    }
}

fun printError() {
    println("Invalid command, try `github-cli help`")
}

fun printHelp() {
    helpFormatter.printHelp("gitlab [OPTION]...", options)
}
