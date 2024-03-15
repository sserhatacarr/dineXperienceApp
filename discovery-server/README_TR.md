# Discovery Servisi

[Go to English README](README.md)

Discovery Servisi, mikroservis mimarimizin anahtar bir bileşenidir. Mikroservislerin kaydını sağlar ve hizmet keşfi sağlar, bu da hizmetlerin yük dengelemesi ve failover için önemlidir.


## Ana Özellikler

- Tüm mikroservisleri kaydeder.
- Yük dengelemesi ve failover için hizmet keşfini sağlar.
- Spring Boot ve Eureka ile entegre olur.

## Yapılandırma

Discovery Servisi'nin yapılandırması `application.yml` dosyasında bulunur. Bu dosya, servisin hangi portta çalışacağını ve Eureka istemci yapılandırmasını belirtir.



## Docker

Bu servis, Docker'da çalışacak şekilde paketlenmiştir. Dockerfile, Docker imajının nasıl oluşturulacağını belirtir.

## Çalıştırma

Docker imajını oluşturmak ve çalıştırmak için aşağıdaki komutları kullanabilirsiniz:

```bash
docker build -t discovery-service .
docker run -p 8761:8761 discovery-service
```

Bu komutlar önce Docker imajını oluşturur ve ardından discovery-service'i 8761 portunda çalıştırır.

## Bağımlılıklar

- **Spring Boot:** Discovery Servisi, Spring Boot kullanılarak oluşturulmuştur.
- **Eureka Server:** Discovery Servisi, hizmet kaydı ve keşfi için Eureka Server'ı kullanır.

Lütfen tüm mikroservislerin hizmet keşfinin doğru bir şekilde çalışması için Discovery Servisi'ne kaydolması gerektiğini unutmayın.