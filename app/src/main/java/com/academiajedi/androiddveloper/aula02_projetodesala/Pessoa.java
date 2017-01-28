package com.academiajedi.androiddveloper.aula02_projetodesala;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alexsoaresdesiqueira on 27/01/17.
 */

public class Pessoa implements Parcelable {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    private Pessoa(Parcel from) {
        nome = from.readString();
        idade = from.readInt();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public static Parcelable.Creator<Pessoa> CREATOR = new Parcelable.Creator<Pessoa>() {

        @Override
        public Pessoa createFromParcel(Parcel source) {
            return new Pessoa(source);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeInt(idade);
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nIdade: " + this.idade;
    }
}
