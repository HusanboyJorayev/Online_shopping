package com.example.online_shopping.simpleCrud;

import org.springframework.http.ResponseEntity;

public interface SimpleCrud<K, V> {
    ResponseEntity<V> create(V dto);

    ResponseEntity<V> get(K id);

    ResponseEntity<V> update(V dto, K id);

    ResponseEntity<V> delete(K id);
}
