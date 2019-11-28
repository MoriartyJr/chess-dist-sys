export class User {
    private id: number;
    public first = "";
    public last = "";
    public email = "";
    private password = "";

    public constructor(first: string, last: string, email: string, password: string) {
        this.first = first;
        this.last = last;
        this.email = email;
        this.password = password;
    }

    public GetFirst(): string {
        return this.first;
    }

    public GetLast(): string {
        return this.last;
    }

    public GetEmail(): string {
        return this.email;
    }
}