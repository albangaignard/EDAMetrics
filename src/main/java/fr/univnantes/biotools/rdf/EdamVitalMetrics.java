/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univnantes.biotools.rdf;

import org.apache.jena.rdf.model.Model;

/**
 *
 * @author Alban Gaignard <alban.gaignard@univ-nantes.fr>
 */
public class EdamVitalMetrics {

    private int exactSynonyms;
    private int narrowSynonyms;
    private int broadSynonyms;
    private int data;
    private int topics;
    private int formats;
    private int operations;

    public EdamVitalMetrics() {
    }

    public EdamVitalMetrics(Model m) {
        exactSynonyms = Queries.getCount(Queries.countExactSynonyms, m);
        narrowSynonyms = Queries.getCount(Queries.countNarrowSynonyms, m);
        broadSynonyms = Queries.getCount(Queries.countBroadSynonyms, m);
        data = Queries.getCount(Queries.countData, m);
        topics = Queries.getCount(Queries.countTopics, m);
        formats = Queries.getCount(Queries.countFormats, m);
        operations = Queries.getCount(Queries.countOperations, m);
    }

    public int getExactSynonyms() {
        return exactSynonyms;
    }

    public void setExactSynonyms(int exactSynonyms) {
        this.exactSynonyms = exactSynonyms;
    }

    public int getNarrowSynonyms() {
        return narrowSynonyms;
    }

    public void setNarrowSynonyms(int narrowSynonyms) {
        this.narrowSynonyms = narrowSynonyms;
    }

    public int getBroadSynonyms() {
        return broadSynonyms;
    }

    public void setBroadSynonyms(int broadSynonyms) {
        this.broadSynonyms = broadSynonyms;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getTopics() {
        return topics;
    }

    public void setTopics(int topics) {
        this.topics = topics;
    }

    public int getFormats() {
        return formats;
    }

    public void setFormats(int formats) {
        this.formats = formats;
    }

    public int getOperations() {
        return operations;
    }

    public void setOperations(int operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "EdamVitalMetrics{" + "exactSynonyms=" + exactSynonyms + ", narrowSynonyms=" + narrowSynonyms + ", broadSynonyms=" + broadSynonyms + ", data=" + data + ", topics=" + topics + ", formats=" + formats + ", operations=" + operations + '}';
    }
    
}
