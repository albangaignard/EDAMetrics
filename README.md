# EDAMetrics
Computing basic metrics for the EDAM ontology. 
```
java -jar target/EDAMetrics-0.0.1-SNAPSHOT-standalone.jar -i ~/Desktop/EDAM_1.18.owl -h 
usage: EDAM-Metrics [-cbs] [-cd] [-ces] [-cf] [-cns] [-co] [-ct] [-dd]
       [-df] [-do] [-dt] [-h] [-i <input_owl_file>] [-s] [-sbs] [-ses]
       [-sns] [-v]
EDAM-Metrics aims at computing basic metrics on the EDAM ontology
 -cbs,--count_broad_synonyms            count broad synonyms
 -cd,--count_data                       count data
 -ces,--count_exact_synonyms            count exact synonyms
 -cf,--count_formats                    count formats
 -cns,--count_narrow_synonyms           count narrow synonyms
 -co,--count_operations                 count operations
 -ct,--count_topics                     count topics
 -dd,--list_deep_data                   list deep data (6+ nested levels)
 -df,--list_deep_formats                list deep formats (6+ nested
                                        levels)
 -do,--list_deep_operations             list deep operations (6+ nested
                                        levels)
 -dt,--list_deep_topics                 list deep topics (6+ nested
                                        levels)
 -h,--help                              print the help
 -i,--input_owl_file <input_owl_file>   The input ontology in OWL
 -s,--summary                           outputs a summay table
 -sbs,--sort_broad_synonyms             sort broad synonyms
 -ses,--sort_exact_synonyms             sort exact synonyms
 -sns,--sort_narrow_synonyms            sort narrow synonyms
 -v,--version                           print the version information and
                                        exit
```
# Command line usage examples
### All-in-one "counts"
```
java -jar target/EDAMetrics-0.0.1-SNAPSHOT-standalone.jar -i ~/Desktop/EDAM_1.18.owl --summary
EdamVitalMetrics{exactSynonyms=1109, narrowSynonyms=705, broadSynonyms=60, data=954, topics=238, formats=499, operations=528}
```
### Deep "Operation" concepts (6+ rdfs:subClassOf)
```
java -jar target/EDAMetrics-0.0.1-SNAPSHOT-standalone.jar -i ~/Desktop/EDAM_1.18.owl -do      
-----------------------------------------------------------------------------------------------------------
| edam_deep_op                             | label                                                        |
===========================================================================================================
| <http://edamontology.org/operation_0441> | "Transcription regulatory element prediction (DNA-cis)"      |
| <http://edamontology.org/operation_0242> | "Conserved transcription regulatory sequence identification" |
| <http://edamontology.org/operation_0391> | "Protein distance matrix calculation"                        |
| <http://edamontology.org/operation_0544> | "Phylogenetic species tree construction"                     |
| <http://edamontology.org/operation_0434> | "Integrated gene prediction"                                 |
| <http://edamontology.org/operation_3225> | "Variant classification"                                     |
| <http://edamontology.org/operation_3217> | "Scaffold gap completion"                                    |
| <http://edamontology.org/operation_0393> | "Residue cluster calculation"                                |
| <http://edamontology.org/operation_0445> | "Transcription factor binding site prediction"               |
| <http://edamontology.org/operation_0464> | "tRNA gene prediction"                                       |
| <http://edamontology.org/operation_0472> | "GPCR prediction"                                            |
| <http://edamontology.org/operation_3202> | "Polymorphism detection"                                     |
| <http://edamontology.org/operation_3663> | "Homology-based gene prediction"                             |
| <http://edamontology.org/operation_0440> | "Promoter prediction"                                        |
| <http://edamontology.org/operation_0481> | "Protein modelling (loops)"                                  |
| <http://edamontology.org/operation_0479> | "Protein modelling (backbone)"                               |
```
etc. 

### The most described with narrow synonyms concepts
```
java -jar target/EDAMetrics-0.0.1-SNAPSHOT-standalone.jar -i ~/Desktop/EDAM_1.18.owl -sns
-----------------------------------------------------------------------------------------------------------------------------
| edam_class                                     | label                                                 | narrow_syn_count |
=============================================================================================================================
| <http://edamontology.org/topic_0749>           | "Transcription factors and regulatory sites"          | 17               |
| <http://edamontology.org/topic_0602>           | "Molecular interactions, pathways and networks"       | 15               |
| <http://edamontology.org/data_2603>            | "Gene expression data"                                | 14               |
| <http://edamontology.org/topic_0659>           | "Functional, regulatory and non-coding RNA"           | 14               |
| <http://edamontology.org/topic_0154>           | "Small molecules"                                     | 13               |
| <http://edamontology.org/topic_3168>           | "Sequencing"                                          | 12               |
| <http://edamontology.org/topic_3512>           | "Gene transcripts"                                    | 12               |
| <http://edamontology.org/topic_3518>           | "Microarray experiment"                               | 12               |
| <http://edamontology.org/operation_0004>       | "Operation"                                           | 8                |
| <http://edamontology.org/topic_0157>           | "Sequence composition, complexity and repeats"        | 8                |
| <http://edamontology.org/topic_0736>           | "Protein folds and structural domains"                | 8                |
| <http://edamontology.org/topic_3674>           | "Methylated DNA immunoprecipitation"                  | 8                |
| <http://edamontology.org/topic_0082>           | "Structure prediction"                                | 7                |
| <http://edamontology.org/topic_2885>           | "DNA polymorphism"                                    | 7                |
| <http://edamontology.org/topic_3375>           | "Drug metabolism"                                     | 7                |
| <http://edamontology.org/topic_3489>           | "Database management"                                 | 7                |
| <http://edamontology.org/data_1355>            | "Protein signature"                                   | 6                |
| <http://edamontology.org/data_3724>            | "Cultivation parameter"                               | 6                |
| <http://edamontology.org/operation_0239>       | "Sequence motif recognition"                          | 6                |
| <http://edamontology.org/operation_0308>       | "PCR primer design"                                   | 6                |
| <http://edamontology.org/operation_2950>       | "Residue distance calculation"                        | 6                |
| <http://edamontology.org/operation_3092>       | "Protein feature detection"                           | 6                |
| <http://edamontology.org/operation_3280>       | "Named-entity and concept recognition"                | 6                |
| <http://edamontology.org/topic_0097>           | "Nucleic acid structure analysis"                     | 6                |
| <http://edamontology.org/topic_0128>           | "Protein interactions"                                | 6                |
| <http://edamontology.org/topic_0160>           | "Sequence sites, features and motifs"                 | 6                |
| <http://edamontology.org/topic_0593>           | "NMR"                                                 | 6                |
| <http://edamontology.org/topic_0611>           | "Electron microscopy"                                 | 6                |
| <http://edamontology.org/topic_3070>           | "Biology"                                             | 6                |
| <http://edamontology.org/topic_3125>           | "DNA binding sites"                                   | 6                |
| <http://edamontology.org/operation_0314>       | "Gene expression profiling"                           | 5                |
| <http://edamontology.org/operation_0415>       | "Nucleic acid feature detection"                      | 5                |
| <http://edamontology.org/operation_3227>       | "Variant calling"                                     | 5                |
| <http://edamontology.org/topic_0084>           | "Phylogeny"                                           | 5                |
```
etc. 
