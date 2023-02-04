package net.heydaytime.Javazon.functions;

import java.util.Objects;

public class NullChecker {
        public static boolean check(Object obj){
            return Objects.equals(obj, null);
        }
}
