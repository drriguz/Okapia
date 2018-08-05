package com.riguz.okapia.encrypt;

public final class Argon2 {
    static {
        System.loadLibrary("encryption");
    }

    private final int iterations;
    private final int memory;
    private final int parallelism;
    private final int hashLength;

    public Argon2(int iterations, int memory, int parallelism, int hashLength) {
        this.iterations = iterations;
        this.memory = memory;
        this.parallelism = parallelism;
        this.hashLength = hashLength;
    }

    public String argon2i(String password, String salt) {
        return new String(argon2dInternal(iterations, memory, parallelism, password, salt, hashLength));
    }

    public String argon2d(String password, String salt) {
        return new String(argon2dInternal(iterations, memory, parallelism, password, salt, hashLength));
    }

    private native byte[] argon2iInternal(int iterations, int memory, int parallelism, String password, String salt, int hashLength);

    private native byte[] argon2dInternal(int iterations, int memory, int parallelism, String password, String salt, int hashLength);
}
