/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2002-2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "Ant" and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
package com.phenix.pct;

import org.apache.tools.ant.BuildFileTest;
import org.apache.tools.ant.taskdefs.Delete;
import org.apache.tools.ant.taskdefs.Mkdir;

import java.io.File;

import java.util.Vector;


/**
 * Class for testing PCTLibrary task
 * @author <a href="mailto:gilles.querret@nerim.net">Gilles QUERRET</a>
 */
public class PCTLibraryTest extends BuildFileTest {
    public PCTLibraryTest(String name) {
        super(name);
    }

    /**
     * Sets up the fixture
     */
    public void setUp() {
        configureProject("PCTLibrary.xml");

        // Creates a sandbox directory to play with
        Mkdir mkdir = new Mkdir();
        mkdir.setProject(this.getProject());
        mkdir.setDir(new File("sandbox"));
        mkdir.execute();
        mkdir.setDir(new File("sandbox/files"));
        mkdir.execute();
        mkdir.setDir(new File("sandbox/lib"));
        mkdir.execute();
    }

    public void tearDown() {
        Delete del = new Delete();
        del.setProject(this.project);
        del.setDir(new File("sandbox"));
        del.execute();
    }

    /**
     * Attribute destFile should always be defined
     */
    public void test1() {
        expectBuildException("test1", "Library name not defined");
    }

    /**
     * Checks that a new library is created
     */
    public void test2() {
        expectBuildException("test2", "No filesets defined");
    }

    /**
     * Checks that a file is added in the library
     */
    public void test3() {
        executeTarget("test3");

        File pl = new File("sandbox/lib/test.pl");
        assertTrue(pl.exists());

        PLReader r = new PLReader(pl);
        Vector v = r.getFileList();
        assertTrue(v != null);
        assertTrue(v.size() == 1);
    }

    /**
     * Checks that a file is added in the library
     */
    public void test4() {
        executeTarget("test4pre");

        File pl = new File("sandbox/lib/test.pl");
        assertTrue(pl.exists());

        PLReader r = new PLReader(pl);
        Vector v = r.getFileList();
        assertTrue(v != null);
        assertTrue(v.size() == 1);
    }
    
    public void test5() {
        executeTarget("test5");
        
        File pl = new File("sandbox/lib/test.pl");
        assertTrue(pl.exists());
        long size = pl.length();
        
        assertTrue(pl.delete());
        
        executeTarget("test5bis");
        assertTrue(pl.exists());
        assertTrue((pl.length() < size));
    }
    
    public void test6() {
        executeTarget("test6");
        
        File pl = new File("sandbox/lib/test.pl");
        assertTrue(pl.exists());

        PLReader r = new PLReader(pl);
        Vector v = r.getFileList();
        assertTrue(v != null);
        assertTrue(v.size() == 3);
    }
    
    public void test7() {
        expectBuildException("test7", "PL file cannot include itself");
    }
    
    public void test8() {
        executeTarget("test8");
        
        File pl = new File("sandbox/lib/test.pl");
        assertTrue(pl.exists());

        PLReader r = new PLReader(pl);
        Vector v = r.getFileList();
        assertTrue(v != null);
        System.out.println(v.size());
        assertTrue(v.size() == 2);
    }
}
