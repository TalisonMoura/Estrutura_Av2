package br.com.estrutura;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Questao1 {
    public void SwithCase(){
        ArvoreAVL arv = new ArvoreAVL();
        ArvoreAVL.Node root = null;
        int opcao = 0;
        int excluir = 0;
        int buscar = 0;
        try{
            Scanner ler = new Scanner(System.in);
            Scanner scan = new Scanner(new File("dados.txt"));
            do
            {
                System.out.println("Qual opçao deseja realizar? ");
                System.out.println(
                "1 - Inserir\n" +
                "2 - Excluir\n" +
                "3 - Pesquisar\n" +
                "4 - Caminhamento Pré Ordem\n" +
                "5 - Sair");
                System.out.println();
                System.out.print("Opção: ");
                opcao = ler.nextInt();
                switch (opcao)
                {
                    case 1:
                        while (scan.hasNextLine()) {
                            arv.insert(root, Integer.parseInt(scan.nextLine()));
                        }
                        break;
                    case 2:
                        System.out.print("Insira um valor para ser excluido: ");
                        excluir = ler.nextInt();
                        root = arv.deleteNode(root, excluir);
                        arv.print(root);
                        break;
                    case 3:
                        System.out.print("Digite um numero para buscar na arvore: ");
                        buscar = ler.nextInt();
                        if(arv.pesquisar(buscar)){
                            System.out.println("Elemento existe na árvore");
                        }else{
                            System.out.println("Elemento não existe na árvore");
                        }
                        break;
                    case 4:
                        System.out.println("Árvore Pré-Ordem:");
                        arv.preOrder(root);
                        break;
                    case 5:
                        System.out.println("Obrigado por utilizar");
                        break;
                    default:
                        System.out.println("Escolha uma opção correta");
                        break;
                }
            }while (opcao != 5);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}