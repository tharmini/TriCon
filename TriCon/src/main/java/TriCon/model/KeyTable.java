
/*
 *  Copyright 2017 copyright to triconnect2017@gmail.com
 *
 *
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *
 *    you may not use this file except in compliance with the License.
 *
 *    You may obtain a copy of the License at
 *
 *
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 *
 *    Unless required by applicable law or agreed to in writing, software
 *
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 *    See the License for the specific language governing permissions and
 *
 *    limitations under the License
 */

package TriCon.model;

import org.springframework.data.annotation.Id;

public class KeyTable {
    @Id
    private String id;
    private String UserName;
    private String PrivateKeyPath;
    private String PublicKeyPath;
    private String KeyWord;


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPrivateKeyPath() {
        return PrivateKeyPath;
    }

    public void setPrivateKeyPath(String privateKeyPath) {
        PrivateKeyPath = privateKeyPath;
    }

    public String getPublicKeyPath() {
        return PublicKeyPath;
    }

    public void setPublicKeyPath(String publicKeyPath) {
        PublicKeyPath = publicKeyPath;
    }

    public String getKeyWord() {
        return KeyWord;
    }

    public void setKeyWord(String keyWord) {
        KeyWord = keyWord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
