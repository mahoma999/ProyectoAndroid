#include <stdio.h>
#include <malloc.h>

int ** matriz(int,int);
void imprimirMatris(int,int,int **);
void llenarMatris(int,int,int**);
int main() {
    int f,c;
    int** m=NULL;
    printf("FILAS: " );
    scanf("%d",&f);
    printf("\n");
    printf("COLUMNAS: ");
    scanf("%d",&c);
    m= matriz(f,c);
    llenarMatris(f,c,m);
    imprimirMatris(f,c,m);
    return 0;
}
int ** matriz(int f,int c){
    int **m=NULL;
    m=(int **)malloc(f * sizeof(int *) );
    for(int i=0;i<c;i++)
        *(m+i)=(int*)malloc(c*sizeof(int) );
    return m;
}

void imprimirMatris(int f, int c,int **m){
    for(int i=0;i<f;i++)
        for(int j=0;j<c;j++)
            printf("m[%d][%d]=%d\n",i,j,m[i][j]);

}
void llenarMatris(int f,int c,int **m){
    int valor;
    printf("LLENAR MATRIS\n");
    for(int i=0;i<f;i++)
        for(int j=0;j<c;j++){
            scanf("%d",&valor);
            m[i][j]=valor;
        }
}