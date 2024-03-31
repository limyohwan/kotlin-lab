package com.yohwan.lab.common

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CustomCommandLineRunner(
//    private val userExcelExporter: UserExcelExporter
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        if (args.isEmpty()) return

        if (args[0].equals("createUserExcel")) {
//            userExcelExporter.export(args)
        }
    }
}

class CustomApplicationRunner : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
    }
}