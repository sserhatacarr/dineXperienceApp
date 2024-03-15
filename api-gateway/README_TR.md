
# API Gateway Servisi

API Gateway, microservice mimarimizdeki tüm servislerin merkezi bir giriş noktasıdır. Bu servis, gelen istekleri ilgili mikroservislere yönlendirir.

[Go to English README](README.md)


## Başlıca Özellikler

- Restaurant ve User servislerine yönlendirme yapar.
- Eureka Discovery Server ile entegre çalışır.
- Zipkin ile izleme/tracing desteği sağlar.

## Yapılandırma

`application.yml` dosyasında API Gateway'in yapılandırması bulunur. Bu dosya, servisin hangi portta çalışacağını, hangi servislere yönlendirme yapacağını ve Eureka ve Zipkin ile nasıl entegre olacağını belirler.

## Docker

Bu servis, Docker üzerinde çalışacak şekilde paketlenmiştir. `Dockerfile` dosyası, Docker imajının nasıl oluşturulacağını belirtir.

## Çalıştırma

Docker imajını oluşturmak ve çalıştırmak için aşağıdaki komutları kullanabilirsiniz:

```bash
docker build -t api-gateway .
docker run -p 8080:8080 api-gateway
```

Bu komutlar, öncelikle Docker imajını oluşturur ve ardından `api-gateway` servisini 8080 portunda çalıştırır.

## Bağımlılıklar

- Restaurant Service: API Gateway, Restaurant Service'e `/api/v1/restaurants/**` path'indeki istekleri yönlendirir.
- User Service: API Gateway, User Service'e `/api/v1/users/**` path'indeki istekleri yönlendirir.
- Eureka Discovery Server: API Gateway, servis keşfi için Eureka Discovery Server ile entegre çalışır.
- Zipkin: API Gateway, izleme/tracing için Zipkin ile entegre çalışır.

