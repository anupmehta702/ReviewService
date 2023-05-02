## Create SSL certifcate

Reference - https://www.thomasvitale.com/https-spring-boot-ssl-certificate/

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


