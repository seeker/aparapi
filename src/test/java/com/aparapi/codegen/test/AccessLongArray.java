/**
 * Copyright (c) 2016 - 2018 Syncleus, Inc.
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
 */
package com.aparapi.codegen.test;

public class AccessLongArray {
    long[] longs = new long[1024];

    public void run() {
        for (int i = 0; i < 1024; i++) {
            longs[i] = 1;
        }
    }
}
/**{OpenCL{
 typedef struct This_s{
 __global long *longs;

 int passid;
 }This;
 int get_pass_id(This *this){
 return this->passid;
 }

 __kernel void run(
 __global long *longs,
 int passid
 ){
 This thisStruct;
 This* this=&thisStruct;
 this->longs = longs;
 this->passid = passid;
 {
 for (int i = 0; i<1024; i++){
 this->longs[i]  = 1L;
 }
 return;
 }
 }
 }OpenCL}**/
