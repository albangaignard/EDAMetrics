/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univnantes.biotools.rdf;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;

/**
 *
 * @author Alban Gaignard <alban.gaignard@univ-nantes.fr>
 */
public class Queries {

    public static String countData = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
            + "SELECT (COUNT(DISTINCT ?edam_data) as ?count_EDAM_data) WHERE { \n"
            + "    ?edam_data rdfs:subClassOf* <http://edamontology.org/data_0006> .\n"
            + "}\n"
            + "";

    public static String countTopics = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
            + "SELECT (COUNT(DISTINCT ?edam_topic) as ?count_EDAM_topics) WHERE { \n"
            + "    ?edam_topic rdfs:subClassOf* <http://edamontology.org/topic_0003> .\n"
            + "}";
    
    public static String countFormats = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
            + "SELECT (COUNT(DISTINCT ?edam_format) as ?count_EDAM_formats) WHERE { \n"
            + "    ?edam_format rdfs:subClassOf* <http://edamontology.org/format_1915> .\n"
            + "}";
    
    public static String countOperations = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
            + "SELECT (COUNT(DISTINCT ?edam_op) as ?count_EDAM_operations) WHERE { \n"
            + "    ?edam_op rdfs:subClassOf* <http://edamontology.org/operation_0004> .\n"
            + "}";
    
    public static String listDeepOperations = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
            + "SELECT DISTINCT ?edam_deep_op ?label WHERE { \n"
            + "    ?edam_deep_op "
            + "         rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf+ " //6+ nested levels
            + "             <http://edamontology.org/operation_0004> .\n"
            + "    ?edam_deep_op rdfs:label ?label\n"
            + "}";
    
    public static String listDeepTopics = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
            + "SELECT DISTINCT ?edam_deep_topic ?label WHERE { \n"
            + "    ?edam_deep_topic "
            + "         rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf+ " //6+ nested levels
            + "             <http://edamontology.org/topic_0003> .\n"
            + "    ?edam_deep_topic rdfs:label ?label\n"
            + "}";
    
    public static String listDeepFormats = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
            + "SELECT DISTINCT ?edam_deep_formats ?label WHERE { \n"
            + "    ?edam_deep_formats "
            + "         rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf+ " //6+ nested levels
            + "             <http://edamontology.org/format_1915> .\n"
            + "    ?edam_deep_formats rdfs:label ?label\n"
            + "}";
    
    public static String listDeepData = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
            + "SELECT DISTINCT ?edam_deep_data ?label WHERE { \n"
            + "    ?edam_deep_data "
            + "         rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf/rdfs:subClassOf+ " //6+ nested levels
            + "             <http://edamontology.org/data_0006> .\n"
            + "    ?edam_deep_data rdfs:label ?label\n"
            + "}";

    public static String countExactSynonyms = "PREFIX prov: <http://www.w3.org/ns/prov#>\n"
            + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
            + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
            + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
            + "\n"
            + "SELECT (COUNT(DISTINCT ?syn) as ?exact_syn_count) WHERE {\n"
            + "    ?edam_concept <http://www.geneontology.org/formats/oboInOwl#hasExactSynonym> ?syn .\n"
            + "}";

    public static String sortedExactSynonyms = "PREFIX prov: <http://www.w3.org/ns/prov#>\n"
            + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
            + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
            + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
            + "\n"
            + "select ?edam_class ?label (count(distinct ?syn) as ?exact_syn_count) WHERE { \n"
            + "    ?edam_class <http://www.geneontology.org/formats/oboInOwl#hasExactSynonym> ?syn .\n"
            + "	?edam_class rdfs:label ?label\n"
            + "}\n"
            + "GROUP BY ?edam_class ?label\n"
            + "ORDER BY DESC(?exact_syn_count)";

    public static String countNarrowSynonyms = "PREFIX prov: <http://www.w3.org/ns/prov#>\n"
            + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
            + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
            + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
            + "\n"
            + "SELECT (COUNT(DISTINCT ?syn) as ?narrow_syn_count) WHERE {\n"
            + "    ?edam_concept <http://www.geneontology.org/formats/oboInOwl#hasNarrowSynonym> ?syn .\n"
            + "}";

    public static String sortedNarrowSynonyms = "PREFIX prov: <http://www.w3.org/ns/prov#>\n"
            + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
            + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
            + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
            + "\n"
            + "select ?edam_class ?label (count(distinct ?syn) as ?narrow_syn_count) WHERE { \n"
            + "    ?edam_class <http://www.geneontology.org/formats/oboInOwl#hasNarrowSynonym> ?syn .\n"
            + "	?edam_class rdfs:label ?label\n"
            + "}\n"
            + "GROUP BY ?edam_class ?label\n"
            + "ORDER BY DESC(?narrow_syn_count)";

    public static String countBroadSynonyms = "PREFIX prov: <http://www.w3.org/ns/prov#>\n"
            + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
            + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
            + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
            + "\n"
            + "SELECT (COUNT(DISTINCT ?syn) as ?broad_syn_count) WHERE {\n"
            + "    ?edam_concept <http://www.geneontology.org/formats/oboInOwl#hasBroadSynonym> ?syn .\n"
            + "}";

    public static String sortedBroadSynonyms = "PREFIX prov: <http://www.w3.org/ns/prov#>\n"
            + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
            + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
            + "PREFIX obo: <http://purl.obolibrary.org/obo/>\n"
            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
            + "\n"
            + "select ?edam_class ?label (count(distinct ?syn) as ?broad_syn_count) WHERE { \n"
            + "    ?edam_class <http://www.geneontology.org/formats/oboInOwl#hasBroadSynonym> ?syn .\n"
            + "	?edam_class rdfs:label ?label\n"
            + "}\n"
            + "GROUP BY ?edam_class ?label\n"
            + "ORDER BY DESC(?broad_syn_count)";

    public static void runSelect(String q, Model m) {
        Query query = QueryFactory.create(q);
        QueryExecution queryExec = QueryExecutionFactory.create(query, m);
        ResultSet rs = queryExec.execSelect();
        System.out.println(ResultSetFormatter.asText(rs));
        queryExec.close();
    }
}
