/*
 * Licensed to the author under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.cui.test.generator.internal.net.java.quickcheck.srcgenerator;

import static io.cui.test.generator.internal.net.java.quickcheck.generator.PrimitiveGenerators.fixedValues;

import java.util.Collections;
import java.util.List;

import io.cui.test.generator.internal.net.java.quickcheck.ExtendibleGenerator;
import io.cui.test.generator.internal.net.java.quickcheck.Generator;
import io.cui.test.generator.internal.net.java.quickcheck.StatefulGenerator;
import io.cui.test.generator.internal.net.java.quickcheck.collection.Pair;
import io.cui.test.generator.internal.net.java.quickcheck.collection.Triple;
import io.cui.test.generator.internal.net.java.quickcheck.generator.CombinedGenerators;
import io.cui.test.generator.internal.net.java.quickcheck.generator.PrimitiveGenerators;
import io.cui.test.generator.internal.net.java.quickcheck.generator.support.IntegerGenerator;
import io.cui.test.generator.internal.net.java.quickcheck.generator.support.StringGenerator;

class Users {

    public static Generator<Integer> primitives() {
        return CombinedGenerators.uniqueValues(new IntegerGenerator());
    }

    public static StatefulGenerator<Integer> primitiveSubtypes() {
        return CombinedGenerators.uniqueValues(new IntegerGenerator());
    }

    public static ExtendibleGenerator<Character, String> complexSubtypes() {
        return new StringGenerator();
    }

    public static Generator<Integer> parameters(int min, int max) {
        return new IntegerGenerator(min, max);
    }

    public static <T extends Enum<T>> Generator<T> bounds(Class<T> enumClass) {
        return PrimitiveGenerators.enumValues(enumClass);
    }

    public static Generator<List<Integer>> generics(List<Integer> is) {
        return PrimitiveGenerators.fixedValues(Collections.singletonList(is));
    }

    public static Generator<Triple<Integer, Double, String>> multipleTypeParameters() {
        return fixedValues(new Triple<>(1, 2.0, "x"));
    }

    public static <A, B> Generator<Pair<A, B>> multipleTypeVariable(A a, B b) {
        return fixedValues(new Pair<>(a, b));
    }

    public static Generator<String> varArgsArrays(String... a) {
        return fixedValues(a);
    }

    public static Generator<String> noVarArgsArrays(String[] a, String x) {
        return fixedValues(a);
    }
}
