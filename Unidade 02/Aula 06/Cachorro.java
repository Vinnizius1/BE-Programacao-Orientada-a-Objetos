class Cachorro implements Animal{

    @Override
    public void fazerBarulho() {
        System.out.println("Cachorro fazendo barulho: Au Au");
    }

    @Override
    public void comer() {
        System.out.println("Cachorro comendo ração...");
    }
    
}