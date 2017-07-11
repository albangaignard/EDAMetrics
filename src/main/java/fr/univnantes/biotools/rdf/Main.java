/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univnantes.biotools.rdf;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.log4j.Logger;

/**
 *
 * @author Alban Gaignard <alban.gaignard@univ-nantes.fr>
 */
public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    private static Model model = ModelFactory.createDefaultModel();

    public static void main(String[] args) {

        Options options = new Options();

        Option versionOpt = new Option("v", "version", false, "print the version information and exit");
        Option helpOpt = new Option("h", "help", false, "print the help");

        Option inOwlOpt = OptionBuilder.withArgName("input_owl_file")
                .withLongOpt("input_owl_file")
                .withDescription("The input ontology in OWL")
                .hasArgs()
                .create("i");

        Option countFormatsOpt = OptionBuilder.withArgName("count_formats")
                .withLongOpt("count_formats")
                .withDescription("count formats")
                .create("cf");
        
        Option countOperationsOpt = OptionBuilder.withArgName("count_operations")
                .withLongOpt("count_operations")
                .withDescription("count operations")
                .create("co");
        
        Option listDeepOperationsOpt = OptionBuilder.withArgName("list_deep_operations")
                .withLongOpt("list_deep_operations")
                .withDescription("list deep operations (6+ nested levels)")
                .create("do");
        
        Option listDeepDataOpt = OptionBuilder.withArgName("list_deep_data")
                .withLongOpt("list_deep_data")
                .withDescription("list deep data (6+ nested levels)")
                .create("dd");
        
        Option listDeepFormatsOpt = OptionBuilder.withArgName("list_deep_formats")
                .withLongOpt("list_deep_formats")
                .withDescription("list deep formats (6+ nested levels)")
                .create("df");
        
        Option listDeepTopicsOpt = OptionBuilder.withArgName("list_deep_topics")
                .withLongOpt("list_deep_topics")
                .withDescription("list deep topics (6+ nested levels)")
                .create("dt");

        Option countTopicsOpt = OptionBuilder.withArgName("count_topics")
                .withLongOpt("count_topics")
                .withDescription("count topics")
                .create("ct");

        Option countDataOpt = OptionBuilder.withArgName("count_data")
                .withLongOpt("count_data")
                .withDescription("count data")
                .create("cd");

        Option countExactSynonymsOpt = OptionBuilder.withArgName("count_exact_synonyms")
                .withLongOpt("count_exact_synonyms")
                .withDescription("count exact synonyms")
                .create("ces");

        Option sortExactSynonymsOpt = OptionBuilder.withArgName("sort_exact_synonyms")
                .withLongOpt("sort_exact_synonyms")
                .withDescription("sort exact synonyms")
                .create("ses");

        Option countNarrowSynonymsOpt = OptionBuilder.withArgName("count_narrow_synonyms")
                .withLongOpt("count_narrow_synonyms")
                .withDescription("count narrow synonyms")
                .create("cns");

        Option sortNarrowSynonymsOpt = OptionBuilder.withArgName("sort_narrow_synonyms")
                .withLongOpt("sort_narrow_synonyms")
                .withDescription("sort narrow synonyms")
                .create("sns");

        Option countBroadSynonymsOpt = OptionBuilder.withArgName("count_broad_synonyms")
                .withLongOpt("count_broad_synonyms")
                .withDescription("count broad synonyms")
                .create("cbs");

        Option sortBroadSynonymsOpt = OptionBuilder.withArgName("sort_broad_synonyms")
                .withLongOpt("sort_broad_synonyms")
                .withDescription("sort broad synonyms")
                .create("sbs");

        Option summaryOpt = OptionBuilder.withArgName("summary")
                .withLongOpt("summary")
                .withDescription("outputs a summay table")
                .create("s");

        options.addOption(inOwlOpt);
        options.addOption(countDataOpt);
        options.addOption(countTopicsOpt);
        options.addOption(countOperationsOpt);
        options.addOption(listDeepOperationsOpt);
        options.addOption(listDeepFormatsOpt);
        options.addOption(listDeepDataOpt);
        options.addOption(listDeepTopicsOpt);
        options.addOption(countFormatsOpt);
        options.addOption(countExactSynonymsOpt);
        options.addOption(sortExactSynonymsOpt);
        options.addOption(countNarrowSynonymsOpt);
        options.addOption(sortNarrowSynonymsOpt);
        options.addOption(countBroadSynonymsOpt);
        options.addOption(sortBroadSynonymsOpt);
        options.addOption(summaryOpt);
        options.addOption(versionOpt);
        options.addOption(helpOpt);

        String header = "EDAMetrics aims at computing basic metrics on the EDAM ontology";
        String footer = "\nPlease report any issue to alban.gaignard@univ-nantes.fr";

        try {
            CommandLineParser parser = new BasicParser();
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("EDAM-Metrics", header, options, footer, true);
                System.exit(0);
            }

            if (cmd.hasOption("v")) {
                System.out.println("EDAM-metrics version 0.0.1");
                System.exit(0);
            }

            if (cmd.hasOption("i")) {
                logger.debug("loading input OWL file");
                String inFile = cmd.getOptionValue("i");

//                try {
//                    URL url = new URL(inFile);
//                    URLConnection conn = url.openConnection();
//                    conn.connect();
//                    RDFDataMgr.read(model, inFile);
//                } catch (MalformedURLException e) {
                    // the URL is not in a valid form
                    Path p = Paths.get(inFile);
                    if (!p.toFile().isFile()) {
                        logger.error("Cannot find file " + inFile);
                        System.exit(1);
                    } else {
                        RDFDataMgr.read(model, inFile);
                        logger.debug("loaded " + model.size() + " triples");
                    }
//                } catch (IOException e) {
//                    logger.error("Could not establish connection to " + inFile);
//                }

            }

            if (cmd.hasOption("ces")) {
                logger.debug("counting exact synonyms");
                Queries.runSelect(Queries.countExactSynonyms, model);
            }

            if (cmd.hasOption("ses")) {
                logger.debug("counting exact synonyms");
                Queries.runSelect(Queries.sortedExactSynonyms, model);
            }

            if (cmd.hasOption("cns")) {
                logger.debug("counting narrow synonyms");
                Queries.runSelect(Queries.countNarrowSynonyms, model);
            }

            if (cmd.hasOption("sns")) {
                logger.debug("counting narrow synonyms");
                Queries.runSelect(Queries.sortedNarrowSynonyms, model);
            }

            if (cmd.hasOption("cbs")) {
                logger.debug("counting narrow synonyms");
                Queries.runSelect(Queries.countBroadSynonyms, model);
            }

            if (cmd.hasOption("sbs")) {
                logger.debug("counting narrow synonyms");
                Queries.runSelect(Queries.sortedBroadSynonyms, model);
            }

            if (cmd.hasOption("cf")) {
                logger.debug("counting formats");
                Queries.runSelect(Queries.countFormats, model);
            }

            if (cmd.hasOption("ct")) {
                logger.debug("counting topics");
                Queries.runSelect(Queries.countTopics, model);
            }

            if (cmd.hasOption("cd")) {
                logger.debug("counting data");
                Queries.runSelect(Queries.countData, model);
            }
            
            if (cmd.hasOption("co")) {
                logger.debug("counting operations");
                Queries.runSelect(Queries.countOperations, model);
            }
            
            if (cmd.hasOption("do")) {
                logger.debug("list deep operations");
                Queries.runSelect(Queries.listDeepOperations, model);
            }
            
            if (cmd.hasOption("dt")) {
                logger.debug("list deep topics");
                Queries.runSelect(Queries.listDeepTopics, model);
            }
            
            if (cmd.hasOption("df")) {
                logger.debug("list deep formats");
                Queries.runSelect(Queries.listDeepFormats, model);
            }
            
            if (cmd.hasOption("dd")) {
                logger.debug("list deep data");
                Queries.runSelect(Queries.listDeepData, model);
            }
            
            if (cmd.hasOption("s")) {
                logger.debug("summaries vital metrics");
                EdamVitalMetrics vm = new EdamVitalMetrics(model);
                System.out.println(vm);
            }

            if (cmd.hasOption("v")) {
                logger.info("EDAM-metrics version 0.1.0");
                System.exit(0);
            }

            if (cmd.getOptions().length == 0) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("EDAM-Metrics", header, options, footer, true);
                System.exit(0);
            }

        } catch (ParseException ex) {
            logger.error("Error while parsing command line arguments. Please check the following help:");
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("EDAM-Metrics", header, options, footer, true);
            System.exit(1);
        }

    }

}
