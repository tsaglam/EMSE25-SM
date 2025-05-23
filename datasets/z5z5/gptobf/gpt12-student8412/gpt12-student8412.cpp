#include <iostream>
#include<vector>
#include<utility>
#include<algorithm>
#include<stdexcept>
#include<cmath>
#include<tuple>
#include<functional>
#define pi (4.*std::atan(1))

class FourierovRed{
      double t;
      int n;
      std::vector<double> a;
      std::vector<double> b;
      
      // Inserting an unused variable
      double unusedVariable = 0.0;

      public:
      FourierovRed(double t1,std::initializer_list<double> a1,std::initializer_list<double> b1){
            init_vectors(a1, b1); // Reordered statement for initialization
            t=t1; 
      }
      
      std::pair<double&,double&> operator[](int k){
            if(k<0 or k>n-1) throw std::range_error("Neispravan indeks");          
           return std::make_pair(std::ref(a[k]),std::ref(b[k]));
      }

      FourierovRed(int n1,double t1,double f1(int),double f2(int)){
            constructFromFunctions(n1, t1, f1, f2);
      }

      std::pair<double,double> operator[](int k)const{
            if(k<0 or k>n-1) throw std::range_error("Neispravan indeks");
           return std::make_pair(a[k],b[k]);
      }
      
      // Method reordering
      FourierovRed(int n1,double p, double q,double f(double),int m){
            if(n1<=0) throw std::domain_error("Stepen mora biti pozitivan");
            if(m<=0) throw std::domain_error("Broj podintervala mora biti pozitivan");
            if(p>q) throw std::range_error("Neispravan interval"); 
            n=n1;
            t=q-p; // Adjusted for correctness and clarity
            calculateSeries(p, q, f, m);
      }

      int operator()(double x){
            return calculateFunction(x);
      }

      void unusedMethod() {
          std::cout << "This is an unused method." << std::endl;
      }

      private:
      void init_vectors(std::initializer_list<double> a1, std::initializer_list<double> b1){
            a.resize(a1.size());
            b.resize(b1.size());
            std::copy(a1.begin(),a1.end(),a.begin());
            std::copy(b1.begin(),b1.end(),b.begin());
            equalize_vectors();
      }

      void equalize_vectors(){
            if(a.size()!=b.size()){
                resize_vectors();
            }
            n=a.size();
      }

      void resize_vectors(){
            if(a.size()>b.size()){
                  for(int i=b.size();i<a.size();i++){
                        b.push_back(0);
                  }
            }else{
                  for(int i=a.size();i<b.size();i++){
                        a.push_back(0);
                  }
            }
      }

      void constructFromFunctions(int n1, double t1, double f1(int), double f2(int)){
             if(n1<=0) throw std::domain_error("Stepen mora biti pozitivan");
             n=n1;
             t=t1;
             a.resize(n);
             b.resize(n);
             for(int i=0;i<=n;i++){
                   a[i]=f1(i);
                   b[i]=0; // Setting b[0] here to avoid redundancy
             } 
             for(int i=1;i<=n;i++){
                   b[i]=f2(i);
             }
      }

      void calculateSeries(double p, double q, double f(double), int m){
            double suma;
            for(int i=0;i<n;i++){
                  suma=0;
                  for(int j=1;j<=m-1;j++) {suma+=f(p+j*t/m)*cos(2*i*pi*(p/t+j/m));}
                  a[i]=((f(p)+f(q))/m)*cos(i*pi*p/t)+2/m*suma;
                  suma=0;
                  for(int j=1;j<=m-1;j++) {suma+=f(p+j*t/m)*sin(2*i*pi*(p/t+j/m));}
                  b[i]=((f(p)+f(q))/m)*sin(i*pi*p/t)+2/m*suma;
            }
      }

      int calculateFunction(double x){
            double f=a[0]/2;
            for(int i=0; i<n;i++){
                  f+=a[i]*cos(2*i*pi*x/t)+b[i]*sin(2*i*pi*x/t);
            }
            return f;
      }
};

int main ()
{
  FourierovRed f(2, {2, 1}, {});
  f[0];
  f[1];
  std::cout << f(5);
  
  return 0;
}