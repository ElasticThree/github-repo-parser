package com.elasticthree.projectparser;

import org.apache.commons.cli.*;

/**
 * Created by mmilonakis on 9/3/16.
 */
class ParserCommandLineUtils {
    static CommandLine validateArgs(String[] args, Options options) {

        CommandLine line = null;
        CommandLineParser parser = new DefaultParser();
        try {
            line = parser.parse(options, args);

        } catch (ParseException exp) {
            System.out.println(exp.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("Main", options);
            System.exit(-1);
        }
        return line;
    }

    static Options getCommandLineOpts() {
        Options options = new Options();

        options.addOption(Option.builder().longOpt("username")
                .hasArg()
                .desc("github USERNAME")
                .argName("USERNAME")
                .required()
                .build());
        options.addOption(Option.builder().longOpt("password")
                .hasArg()
                .desc("github PASSWORD")
                .argName("PASSWORD")
                .required()
                .build());
        options.addOption(Option.builder().longOpt("year")
                .hasArg()
                .desc("parse repositories create at YEAR")
                .argName("YEAR")
                .required()
                .build());
        options.addOption(Option.builder().longOpt("from-month")
                .hasArg()
                .desc("start parsing from month MONTH")
                .argName("MONTH")
                .build());
        options.addOption(Option.builder().longOpt("to-month")
                .hasArg()
                .desc("start parsing until month MONTH")
                .argName("MONTH")
                .build());
        options.addOption("d", "download", false,
                "also downlad the repositories in zip-compressed format");
        options.addOption(Option.builder().longOpt("upload")
                .desc("Whether to upload to a neo4j server or not")
                .build());
        options.addOption(Option.builder().longOpt("threads")
                .hasArg()
                .desc("Number of threads to be used")
                .argName("THREADS")
                .build());
        options.addOption("n", "no-keep-files", false,
                "delete the repo directory after downloading-processing");
        return options;
    }
}
