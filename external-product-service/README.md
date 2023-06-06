## Create SSL certifcate

Reference - https://www.thomasvitale.com/https-spring-boot-ssl-certificate/

# Java keystore and truststore concept 
Store is a collection of public or/and private key . They have their own individual password.
There are two types of stores -
1) Java Keystore - Stores your own public and private key.
2) Java truststore - Stores client's/consumer's public key (signed or self signed)

Normally, extract common cert/key from Keystore and then add the .cert file in your common Java trsutstore or refer it individually in your code.
At times, if you have more than one cert key required by your application, then create a seperate application specific Truststore and add both the certificates.

An important hack , you can add a root certifcate/ signing authority Key . By doing so , your application can trust/ interact with all applications that have the certifcates signed by the signing authority.
https://github.com/confluentinc/confluent-platform-security-tools/blob/master/single-trust-store-diagram.pdf


# JKS Key store
keytool -genkeypair -alias externalProducts -keyalg RSA -keysize 4096 -ext "SAN:c=DNS:localhost,DNS:external-product-service-backend,IP:127.0.0.1" -dname "CN=ExternalProdAddidas,OU=product,O=Addidas,C=IN" -storetype JKS -keystore externalProducts.jks -validity 3650 -storepass password
Is CN=anup, OU=addidas, O=addidas, L=pune, ST=maharashtra, C=in
# To view key store
keytool -list -v -keystore externalProducts.jks
#Convert JKS into pc12 format 
keytool -importkeystore -srckeystore externalProducts.jks -destkeystore externalProducts.p12 -deststoretype pkcs12 
# convert an externally signed .cert file into  pk12 
keytool -import -alias externalProducts -file externalProducts.crt -keystore externalProducts.p12 -storepass password
# convert an externally signed .cert into jks
keytool -export -alias mydomain -file reqes.crt -keystore reqes.jks 

#Extract .cert from p12 file
keytool -export -keystore externalProducts.p12 -alias externalProducts -file externalProducts.crt


