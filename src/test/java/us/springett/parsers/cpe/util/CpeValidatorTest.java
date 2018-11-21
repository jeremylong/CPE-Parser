/*
 * This file is part of CPE Parser.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright (c) 2018 Jeremy Long. All Rights Reserved.
 */
package us.springett.parsers.cpe.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeremy Long
 */
public class CpeValidatorTest {

    /**
     * Test of isValid method, of class CpeValidator.
     */
    @Test
    public void testIsValid() {
        assertFalse(CpeValidator.isValid(null));
        assertFalse(CpeValidator.isValid(""));
        assertTrue(CpeValidator.isValid("cpe:2.3:a:mariadb:mariadb:*:*:*:*:*:*:*:*"));
        assertTrue(CpeValidator.isValid("cpe:/o:redhat:enterprise_linux:5"));
        assertTrue(CpeValidator.isValid("cpe:2.3:a:\\\\$0.99_kindle_books_project:\\\\$0.99_kindle_books:6:*:*:*:*:android:*:*"));
        assertTrue(CpeValidator.isValid("cpe:/a:%240.99_kindle_books_project:%240.99_kindle_books:6::~~~android~~"));
        assertTrue(CpeValidator.isValid("cpe:2.3:a:synology:ds_photo\\\\+:3.3:*:*:*:*:android:*:*"));
        assertTrue(CpeValidator.isValid("cpe:/a:synology:ds_photo%2b:3.3::~~~android~~"));
        assertTrue(CpeValidator.isValid("cpe:/a:myanmars:myanmar_housing_%3a_mmhome:1.3::~~~android~~"));
        assertTrue(CpeValidator.isValid("cpe:2.3:a:myanmars:myanmar_housing_\\\\:_mmhome:1.3:*:*:*:*:android:*:*"));
        assertTrue(CpeValidator.isValid("cpe:/a:joomla:joomla%21:2.5.7"));
    }

    /**
     * Test of isValid22 method, of class CpeValidator.
     */
    @Test
    public void testIsValid22() {
        assertFalse(CpeValidator.isValid22(null));
        assertFalse(CpeValidator.isValid22(""));
        assertFalse(CpeValidator.isValid22("cpe:2.3:a:myanmars:myanmar_housing_\\\\:_mmhome:1.3:*:*:*:*:android:*:*"));
        assertFalse(CpeValidator.isValid22("cpe:/t:misterpark:re%3akyu:1::~~~android~~"));
        assertFalse(CpeValidator.isValid22("cpe:/t:misterpark:re%3akyu:1::~~~android~~:lang:invalid"));

        assertTrue(CpeValidator.isValid22("cpe:/a:misterpark:re%3akyu:1::~~~android~~"));
        assertTrue(CpeValidator.isValid22("cpe:/a:icu-project:international_components_for_unicode:::~~~c%2fc%2b%2b~~"));
        assertTrue(CpeValidator.isValid22("cpe:/a:%240.99_kindle_books_project:%240.99_kindle_books:6::~~~android~~"));
        assertTrue(CpeValidator.isValid22("cpe:/a:%240.99_kindle_books_project:%240.99_kindle_books:6::~~~android~~:java"));
        assertTrue(CpeValidator.isValid22("cpe:/::::::"));
        assertTrue(CpeValidator.isValid22("cpe:/a:-:-:-:-:-:-"));
    }

    /**
     * Test of isValid23 method, of class CpeValidator.
     */
    @Test
    public void testIsValid23() {
        assertFalse(CpeValidator.isValid23(null));
        assertFalse(CpeValidator.isValid23(""));
        assertFalse(CpeValidator.isValid23("cpe:2.3:t:myanmars:myanmar_housing_\\\\:_mmhome:1.3:*:*:*:*:android:*:*"));
        assertFalse(CpeValidator.isValid23("cpe:2.3:a:myanmars:myanmar_housing_\\\\:_mmhome:1.3:*:*:*:*:android:*:*:bad"));
        assertFalse(CpeValidator.isValid23("cpe:2.3:a:myanmars:myanmar_housing_\\\\:_mmhome:1.3:*:*:*:*:invalid"));
        assertFalse(CpeValidator.isValid23("cpe:/a:misterpark:re%3akyu:1::~~~android~~"));

        assertTrue(CpeValidator.isValid23("cpe:2.3:a:misterpark:re\\\\:kyu:1:*:*:*:*:android:*:*"));
        assertTrue(CpeValidator.isValid23("cpe:2.3:a:superluckycasino:slots_heaven\\\\:free_slot_machine:1.123:*:*:*:*:android:*:*"));
        assertTrue(CpeValidator.isValid23("cpe:2.3:a:magzter:travel\\\\+leisure:3:*:*:*:*:android:*:*"));
        assertTrue(CpeValidator.isValid23("cpe:2.3:a:icu-project:international_components_for_unicode:*:*:*:*:*:c\\\\/c\\\\+\\\\+:*:*"));
        assertTrue(CpeValidator.isValid22("cpe:2.3:a:joomla:joomla\\\\!:2.5.7:*:*:*:*:*:*:*"));
        assertTrue(CpeValidator.isValid22("cpe:2.3:a:cisco:unified_communications_manager_im_and_presence_service:9.1\\\\(1\\\\):*:*:*:*:*:*:*"));
        assertTrue(CpeValidator.isValid22("cpe:2.3:a:rpm:rpm:1.4.2\\\\/a:*:*:*:*:*:*:*"));
        
        assertTrue(CpeValidator.isValid22("cpe:2.3:*:*:*:*:*:*:*:*:*:*:*"));
        assertTrue(CpeValidator.isValid22("cpe:2.3:-:-:-:-:-:-:-:-:-:-:-"));
    }

}
