
# API Gateway Servisi

[İngilizce README'ye git](README.md)

API Gateway, microservice mimarimizdeki tüm servislerin merkezi bir giriş noktasıdır. Bu servis, gelen istekleri ilgili mikroservislere yönlendirir.

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

## İletişim

### Serhat Acar

<a href="https://github.com/sserhatacarr" target="_blank">
<img  src=https://img.shields.io/badge/github-%2324292e.svg?&style=for-the-badge&logo=github&logoColor=white alt=github style="margin-bottom: 20px;" />
</a>
<a href = "mailto:sserhatacarr@gmail.com?subject = Geri Bildirim&body = Mesaj">
<img src=https://img.shields.io/badge/send-email-email?&style=for-the-badge&logo=microsoftoutlook&color=CD5C5C alt=gmail style="margin-bottom: 20px; margin-left:20px" />
</a>
<a href="https://linkedin.com/in/sserhatacarr" target="_blank">
<img src=https://img.shields.io/badge/linkedin-%231E77B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white alt=linkedin style="margin-bottom: 20px; margin-left:20px" />
</a>  

## Talenthub Bootcamp - N11 & Patika

<div align="center">
  <a href="https://www.n11.com/">
    <img src="../img/n11-logo.png" alt="Logo" width="220" height="140">
  </a>

<h3 align="center">Şirket: N11.com</h3>
</div>

<div align="center">
  <a href="https://www.patika.dev/">
    <img src="../img/patika-logo.png" alt="Logo" width="350" height="300">
  </a>
<h3 align="center">Organizatör: Patika.dev</h3>   
</div>
