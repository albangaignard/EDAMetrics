/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fr.univnantes.biotools.rdf.Main;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author Alban Gaignard <alban.gaignard@univ-nantes.fr>
 */
public class MainTest {

    public MainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("http.proxyHost", "cache.ha.univ-nantes.fr");
        System.setProperty("http.proxyPort", "3128");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    @Ignore
    public void hello() {
        String [] params = {"-i", "http://edamontology.org/EDAM_1.17.owl", "-ces"};
        Main.main(params);
    }
}
