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
 * Copyright (c) Steve Springett. All Rights Reserved.
 */
package us.springett.parsers.cpe.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CPE Validation routines to ensure that the CPE conforms to the CPE
 * specification.
 *
 * @author Jeremy Long
 * @author Steve Springett.
 */
public final class CpeValidator {

    private static final Pattern SCHEMA_22_OFFICIAL = Pattern.compile("[c][pP][eE]:/[AHOaho]?(:[A-Za-z0-9\\._\\-~%]*){0,6}");

    private static final Pattern SCHEMA_23_OFFICIAL = Pattern.compile("cpe:2\\.3:[aho\\*\\-](:(((\\?*|\\*?)([a-zA-Z0-9\\-\\._]|(\\\\[\\\\\\*\\?!\"#$$%&'\\(\\)\\+,/:;<=>@\\[\\]\\^`\\{\\|}~]))+(\\?*|\\*?))|[\\*\\-])){5}(:(([a-zA-Z]{2,3}(-([a-zA-Z]{2}|[0-9]{3}))?)|[\\*\\-]))(:(((\\?*|\\*?)([a-zA-Z0-9\\-\\._]|(\\\\[\\\\\\*\\?!\"#$$%&'\\(\\)\\+,/:;<=>@\\[\\]\\^`\\{\\|}~]))+(\\?*|\\*?))|[\\*\\-])){4}");

    /**
     * Empty constructor for this utility class.
     */
    private CpeValidator() {
        //empty
    }

    /**
     * Validates the given CPE against the CPE 2.2 or 2.3 specification.
     *
     * @param cpeString the CPE to validate
     * @return <code>true</code> if the CPE is valid; otherwise
     * <code>false</code>
     */
    public static boolean isValid(String cpeString) {
        if (cpeString == null || cpeString.isEmpty()) {
            return false;
        }
        if (cpeString.regionMatches(0, "cpe:2.3", 0, 7)) {
            return isValid23(cpeString);
        }
        return isValid22(cpeString);

    }

    /**
     * Validates the given CPE against the CPE 2.2 specification.
     *
     * @param cpeString the CPE to validate
     * @return <code>true</code> if the CPE is valid; otherwise
     * <code>false</code>
     */
    public static boolean isValid22(String cpeString) {
        if (cpeString == null || cpeString.isEmpty()) {
            return false;
        }
        Matcher matcher = SCHEMA_22_OFFICIAL.matcher(cpeString);
        return matcher.matches();
    }

    /**
     * Validates the given CPE against the CPE 2.3 specification.
     *
     * @param cpeString the CPE to validate
     * @return <code>true</code> if the CPE is valid; otherwise
     * <code>false</code>
     */
    public static boolean isValid23(String cpeString) {
        if (cpeString == null || cpeString.isEmpty()) {
            return false;
        }
        Matcher matcher = SCHEMA_23_OFFICIAL.matcher(cpeString);
        return matcher.matches();
    }
}
